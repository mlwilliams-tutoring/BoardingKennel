package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    DogServiceImpl dogService;

    @PostMapping(path = "/addDog", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog) {
        dogService.save(dog);
        return new ResponseEntity(dog, HttpStatus.CREATED);
    }

    @PostMapping(path = "/checkOutDog", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Dog>> checkOutDog(@RequestBody Dog dog) {
        dogService.delete(dog);
        List<Dog> remainingDogs = dogService.getAllDogs();
        return new ResponseEntity(remainingDogs, HttpStatus.OK);
    }
}
