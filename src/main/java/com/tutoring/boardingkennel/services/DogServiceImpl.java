package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.repositories.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("dogService")
@Transactional
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepo dogRepo;

    @Override
    public void save(Dog dog) {
        dogRepo.save(dog);
    }

    @Override
    public Dog findByName(String name) {
        return null;
    }
}
