package org.foodies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstablishmentFilterResponseDTO {

    private Long id;
    private String name;
    private String address;
    private Float rating;
    private Integer numberRating;
    private Float distance;

}
