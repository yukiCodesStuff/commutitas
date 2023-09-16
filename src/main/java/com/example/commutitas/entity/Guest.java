package com.example.commutitas.entity;

import com.example.commutitas.enums.DietaryRestrictions;
import com.example.commutitas.enums.Religion;

import java.util.Collections;
import java.util.List;

public class Guest {

    public String name;
    public Integer age;
    public List<DietaryRestrictions> dietaryRestrictions;
    private Religion religion;

    public Guest() {

    }

    public Guest(
            String name,
            Integer age
    ) {
        this.name = name;
        this.age = age;
        this.dietaryRestrictions = (Collections.emptyList());
    }

    public Guest(
            String name,
            Integer age,
            List<DietaryRestrictions> dietaryRestrictions
    ) {
        this.name = name;
        this.age = age;
        this.dietaryRestrictions = dietaryRestrictions;
    }

}