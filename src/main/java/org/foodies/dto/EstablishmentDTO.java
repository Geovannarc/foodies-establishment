package org.foodies.dto;

import lombok.Getter;
import org.foodies.model.EstablishmentModel;

import java.util.List;

@Getter
public class EstablishmentDTO {

    private String business_status;
    private GeometryDTO geometry;
    private String name;
    private String place_id;
    private String price_level;
    private List<String> types;
    private String user_ratings_total;
    private String contact_info;
    private String vicinity;

    public EstablishmentModel getModel() {
        EstablishmentModel model = new EstablishmentModel();
        model.setAddress(this.vicinity);
        model.setContact_info(this.contact_info);
        model.setLatitude(this.geometry.getLocation().getLat());
        model.setLongitude(this.geometry.getLocation().getLng());
        model.setName(this.name);
        model.setGoogle_place_id(this.place_id);
        return model;
    }
}
