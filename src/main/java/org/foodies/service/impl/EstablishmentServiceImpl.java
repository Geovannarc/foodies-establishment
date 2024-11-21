package org.foodies.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.foodies.dto.EstablishmentDTO;
import org.foodies.model.EstablishmentModel;
import org.foodies.repository.EstablishmentRepository;
import org.foodies.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EstablishmentServiceImpl implements EstablishmentService {

    @Autowired
    private EstablishmentRepository repository;

    @Transactional
    public void save(EstablishmentDTO estabelecimento) {
        try {
            repository.saveEstablishment(estabelecimento.getModel());
            Integer restaurantId = repository.getEstablishmentId(estabelecimento.getModel().getName());
            for (String category : estabelecimento.getTypes()) {
                repository.saveCategory(category);
                final Integer id = repository.getCategoryId(category);
                repository.saveEstablishmentCategory(restaurantId, id);
            }
        } catch (DataIntegrityViolationException e) {
            log.info("Erro ao salvar restaurante: {}", e.getStackTrace());
            throw new DataIntegrityViolationException("Erro ao salvar restaurante");
        }
    }

    @Override
    public List<EstablishmentModel> find(String name) {
        return repository.findByName(name);
    }

    @Override
    public EstablishmentModel findById(Long id) {
        Optional<EstablishmentModel> establishment = repository.findById(id);
        if (establishment.isEmpty()) {
            log.info("Estabelecimento não encontrado");
            return null;
        } else {
            return establishment.get();
        }
    }
}
