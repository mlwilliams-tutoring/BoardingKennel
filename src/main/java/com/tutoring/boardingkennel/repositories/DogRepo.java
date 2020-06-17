package com.tutoring.boardingkennel.repositories;

import com.tutoring.boardingkennel.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepo extends JpaRepository<Dog, Long> {
    Dog findByName(String name);
}
