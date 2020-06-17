package com.tutoring.boardingkennel.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Describes the dog that is being borded.
 * Has breed, kennel type, name, age, allergies,
 * how much food they need, whether or not they've been fed, and how much they've been fed
 *
 * @author Mikaila Williams
 * @version 1.0
 */

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private long id;
    private String breed;
    private int age;
    private String name;
    private String allergies;
    private int amountOfFood; //in cups
    private int amountFed; //amount of food given to dog today
    private boolean isFed;
    @Enumerated(EnumType.STRING)
    private KennelSize kennelSize;

    public Dog(){
        this.allergies = "";
        this.name = "";
        this.breed = "";
        this.kennelSize = KennelSize.SMALL;
    }

    public Dog(String breed, int age, String name, String allergies,
               int amountOfFood, boolean isFed, KennelSize kennelSize){
        this.breed = breed;
        this.age = age;
        this.name = name;
        this.allergies = allergies;
        this.amountOfFood = amountOfFood;
        this.isFed = isFed;
        this.kennelSize = kennelSize;
        this.amountFed = 0;
    }

    /**
     * Prints out the dog's information
     */
    public void printDogInformation() {
        System.out.println(name + "'s breed is " + breed);
        System.out.println(name + "'s age is " + age);
        if (!allergies.isEmpty()) {
            System.out.println(name + "'s allergies are: " + allergies);
        } else {
            System.out.println(name + " does not have any allergies.");
        }
        if (isFed) {
            System.out.println(name + " has been fed " + amountFed + " cups of food.");
        } else {
            System.out.println(name + " is hungry!");
        }
        System.out.println(name + " is in kennel size " + kennelSize);
    }

    /**
     * Feeds the dog the given amount of food.
     * Will say the dog is fed when they have been
     * given the amount of food they need
     *
     * @param amountOfFood
     */
    public void feedDog(int amountOfFood) {
        if (isFed) {
            System.out.println(name + " has already been fed");
        } else {
            System.out.println(name + " has been given "
                    + amountOfFood + " cups of food");
            amountFed = amountFed + amountOfFood;
            if (amountFed >= this.amountOfFood) {
                isFed = true;
            }
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAllergies() {
        return allergies;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public int getAmountFed() {
        return amountFed;
    }

    public boolean isFed() {
        return isFed;
    }

    public KennelSize getKennelSize() {
        return kennelSize;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setAmountFed(int amountFed) {
        this.amountFed = amountFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public void setKennelSize(KennelSize kennelSize) {
        this.kennelSize = kennelSize;
    }
}

