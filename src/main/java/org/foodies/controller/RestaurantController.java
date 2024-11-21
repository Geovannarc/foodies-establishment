package org.foodies.controller;

import org.foodies.dto.EstablishmentDTO;
import org.foodies.model.EstablishmentModel;
import org.foodies.service.EstablishmentService;
import org.foodies.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
public class RestaurantController {

    @Autowired
    private EstablishmentService restaurantService;

    @PostMapping("/save")
    public ResponseEntity<ResponseBuilder> saveRestaurant(@RequestBody final EstablishmentDTO establishmentDTO) {
        try {
            restaurantService.save(establishmentDTO);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(new ResponseBuilder("Estabelecimento já cadastrado"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseBuilder> findRestaurant(@RequestParam("name") final String name) {
        final List<EstablishmentModel> restaurants = restaurantService.find(name);
        return new ResponseEntity<>(new ResponseBuilder(restaurants), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseBuilder> findRestaurantById(@RequestParam("id") final Long id) {
        final EstablishmentModel restaurants = restaurantService.findById(id);
        if (restaurants == null) {
            return new ResponseEntity<>(new ResponseBuilder("Estabelecimento não encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ResponseBuilder(restaurants), HttpStatus.OK);
    }
}
