package org.foodies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Setter
@Getter
@Table(name = "establishment")
public class EstablishmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private Float rating;
    private BigInteger number_rating;
    private String contact_info;
    private String google_place_id;
    private String business_status;

}
