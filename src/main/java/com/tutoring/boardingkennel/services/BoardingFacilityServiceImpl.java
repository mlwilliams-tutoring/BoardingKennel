package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;
import com.tutoring.boardingkennel.repositories.BoardingFacilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardingFacilityServiceImpl implements BoardingFacilityService {

    @Autowired
    BoardingFacilityRepo facilityRepo;
    @Autowired
    DogServiceImpl dogService;

    @Override
    public void updateSmallKennels(int numOfSmallKennels) {

    }

    @Override
    public void updateMediumKennels(int numOfMedKennels) {

    }

    @Override
    public void updateLargeKennels(int numOfLargeKennels) {

    }

    @Override
    public Map<String, Integer> getAvailability() {
        HashMap<String, Integer> availability = new HashMap<>();
        BoardingFacility facility = facilityRepo.findByName("Tutoring Kennel");
        availability.put("totalNumSmallKennels", facility.getNumSmallKennels());
        availability.put("totalNumMedKennels", facility.getNumMediumKennels());
        availability.put("totalNumLargeKennels", facility.getNumLargeKennels());

        availability.put("numOfSmallDogs",
                dogService.findByKennelSize(KennelSize.SMALL).size());
        availability.put("numOfMedDogs",
                dogService.findByKennelSize(KennelSize.MEDIUM).size());
        availability.put("numOfLargeDogs",
                dogService.findByKennelSize(KennelSize.LARGE).size());

        availability.put("smallKennelsAvailable",
                (facility.getNumSmallKennels() - availability.get("numOfSmallDogs")));
        availability.put("mediumKennelsAvailable",
                (facility.getNumMediumKennels() - availability.get("numOfMedDogs")));
        availability.put("largeKennelsAvailable",
                (facility.getNumLargeKennels() - availability.get("numOfLargeDogs")));
        return availability;
    }

    @Override
    public void feedDogs() {

    }

    @Override
    public List<Dog> getBoardingDogs() {
        return dogService.getAllDogs();
    }
}
