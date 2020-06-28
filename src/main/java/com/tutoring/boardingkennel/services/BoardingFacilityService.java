package com.tutoring.boardingkennel.services;

import java.util.Map;

public interface BoardingFacilityService {
    void updateSmallKennels(int numOfSmallKennels);
    void updateMediumKennels(int numOfMedKennels);
    void updateLargeKennels(int numOfLargeKennels);

    Map<String, Integer> getAvailability();

    void feedDogs();

}
