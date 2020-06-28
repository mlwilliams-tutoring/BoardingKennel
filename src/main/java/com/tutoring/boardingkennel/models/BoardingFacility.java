package com.tutoring.boardingkennel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Describes the boarding facility.
 * Has number of each size kennel for the facility
 *
 *
 * @author Mikaila Williams
 * @version 2.0
 */

@Entity
public class BoardingFacility {

    @Id
    @GeneratedValue
    private Long id;
    private String name = "Tutoring Kennel";
    private int numSmallKennels;
    private int numMediumKennels;
    private int numLargeKennels;
//    @OneToMany(mappedBy = "facility")
//    List<Dog> dogs;

    /**
     * Empty Constructor
     */
    public BoardingFacility(){
    }

    /**
     * Explicit Constructor
     *
     */
    public BoardingFacility(String name, int numSmallKennels, int numMediumKennels, int numLargeKennels){
        this.numSmallKennels = numSmallKennels;
        this.numMediumKennels = numMediumKennels;
        this.numLargeKennels = numLargeKennels;
    }

    public String getName() {
        return name;
    }

    public int getNumSmallKennels() {
        return numSmallKennels;
    }

    public int getNumMediumKennels() {
        return numMediumKennels;
    }

    public int getNumLargeKennels() {
        return numLargeKennels;
    }


}

