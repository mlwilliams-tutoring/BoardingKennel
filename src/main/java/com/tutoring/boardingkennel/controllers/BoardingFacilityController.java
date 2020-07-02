package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.BoardingFacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BoardingFacilityController {

    @Autowired
    BoardingFacilityServiceImpl service;

    @GetMapping(path = "/availability", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Integer>> getAvailability() {
        Map<String, Integer> availability = service.getAvailability();
        return new ResponseEntity(availability, HttpStatus.OK);
    }
}
