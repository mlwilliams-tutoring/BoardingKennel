package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @Autowired
    DogServiceImpl dogService;

    @PostMapping(path = "/addDog", consumes = "application/json", produces = "application/json")
    public void addDog(@RequestBody Dog dog) {
        dogService.save(dog);
    }
}
