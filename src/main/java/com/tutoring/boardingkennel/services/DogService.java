package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;

public interface DogService {
    void save(Dog dog);
    Dog findByName(String name);
}
