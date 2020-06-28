package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;
import com.tutoring.boardingkennel.repositories.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Dog> findByKennelSize(KennelSize kennelSize) {
        return dogRepo.findAllByKennelSize(kennelSize);
    }

    /**
     * Feeds the dog the given amount of food.
     * Will say the dog is fed when they have been
     * given the amount of food they need
     *
     * @param amountOfFood
     * @param dog
     */
    private void feedDog(int amountOfFood, Dog dog) {
        if (dog.getIsFed()) {
            //do nothing
        } else {
            //update dog's amount fed and if they are full
        }
    }
}
