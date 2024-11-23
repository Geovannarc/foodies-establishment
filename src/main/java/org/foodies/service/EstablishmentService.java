package org.foodies.service;


import org.foodies.dto.EstablishmentDTO;
import org.foodies.dto.EstablishmentFilterResponseDTO;
import org.foodies.model.EstablishmentModel;

import java.util.List;

public interface EstablishmentService {

    void save(EstablishmentDTO establishmentDTO);

    List<EstablishmentModel> find(String name);

    EstablishmentModel findById(Long id);

    List<EstablishmentFilterResponseDTO> findByGeolocation(Double latitude, Double longitude);

    List<EstablishmentFilterResponseDTO> findByCategory(Integer category);

    List<EstablishmentFilterResponseDTO> findByRating();
}
