package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.BoardingFacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class BoardingFacilityController {

    @Autowired
    BoardingFacilityServiceImpl service;

    @GetMapping(path = "/availability", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Integer>> getAvailability() {
        Map<String, Integer> availability = service.getAvailability();
//        HashMap<String, Integer> availability = new HashMap<>();
//        availability.put("numOfSmallDogs", 3);
//        availability.put("smallKennelsAvailable", 17);
//        availability.put("totalNumSmallKennels", 20);
//        availability.put("numOfMedDogs", 12);
//        availability.put("mediumKennelsAvailable", 3);
//        availability.put("totalNumMedKennels", 15);
//        availability.put("numOfLargeDogs", 5);
//        availability.put("largeKennelsAvailable", 5);
//        availability.put("totalNumLargeKennels", 10);
        return new ResponseEntity(availability, HttpStatus.OK);
    }

    @GetMapping(path = "/boardingDogs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = service.getBoardingDogs();
        return new ResponseEntity(Collections.emptyList(), HttpStatus.OK);
    }
}
