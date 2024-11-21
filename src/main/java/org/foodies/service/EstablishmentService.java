package org.foodies.service;


import org.foodies.dto.EstablishmentDTO;
import org.foodies.model.EstablishmentModel;

import java.util.List;

public interface EstablishmentService {

    void save(EstablishmentDTO establishmentDTO);

    List<EstablishmentModel> find(String name);

    EstablishmentModel findById(Long id);
}
