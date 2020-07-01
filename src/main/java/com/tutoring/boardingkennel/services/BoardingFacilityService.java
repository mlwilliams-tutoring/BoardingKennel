package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;

import java.util.List;
import java.util.Map;

public interface BoardingFacilityService {
    void updateSmallKennels(int numOfSmallKennels);
    void updateMediumKennels(int numOfMedKennels);
    void updateLargeKennels(int numOfLargeKennels);

    Map<String, Integer> getAvailability();

    void feedDogs();

    List<Dog> getBoardingDogs();
}
