package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;

import java.util.List;

public interface DogService {
    void save(Dog dog);
    Dog findByName(String name);
    List<Dog> findByKennelSize(KennelSize kennelSize);
}
