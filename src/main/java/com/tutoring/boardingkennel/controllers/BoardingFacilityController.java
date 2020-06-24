package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BoardingFacilityController {

    @GetMapping(path = "/availability", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Integer>> getTotalNumOfKennels() {
        HashMap<String, Integer> availability = new HashMap<>();
        availability.put("numOfSmallDogs", 3);
        availability.put("smallKennelsAvailable", 17);
        availability.put("totalNumSmallKennels", 20);
        availability.put("numOfMedDogs", 12);
        availability.put("mediumKennelsAvailable", 3);
        availability.put("totalNumMedKennels", 15);
        availability.put("numOfLargeDogs", 5);
        availability.put("largeKennelsAvailable", 5);
        availability.put("totalNumLargeKennels", 10);
        return new ResponseEntity(availability, HttpStatus.OK);
    }
}
