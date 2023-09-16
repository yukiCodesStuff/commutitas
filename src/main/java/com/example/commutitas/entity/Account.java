package com.example.commutitas.entity;

import com.example.commutitas.enums.AccountType;
import com.example.commutitas.enums.DietaryRestrictions;
import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )

    private Long id;
    private Location location;
    private String phoneNumber;
    private String email;
    private String name;
    private AccountType accountType;
    private List<DietaryRestrictions> dietaryRestrictions;
    private Religion religion;

//    @JsonProperty
//    private LocalDate dob;
    @Transient
    private Integer age;
    private String bio;

    public Account() {
    }

    public Account(
            Long id,
            Location location,
            String phoneNumber,
            String email,
            String name,
            AccountType accountType,
            List<DietaryRestrictions> dietaryRestrictions,
            Religion religion,
//            LocalDate dob,
            Integer age,
            String bio) {
        this.id = id;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.accountType = accountType;
        this.dietaryRestrictions = dietaryRestrictions;
        this.religion = religion;
//        this.dob = dob;
        this.age = age;
        this.bio = bio;
    }

    public Account(
            Location location,
            String phoneNumber,
            String email,
            String name,
            AccountType accountType,
            List<DietaryRestrictions> dietaryRestrictions,
            Religion religion,
//            LocalDate dob,
            Integer age,
            String bio) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountType = accountType;
        this.dietaryRestrictions = dietaryRestrictions;
        this.religion = religion;
//        this.dob = dob;
        this.age = age;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Integer getAge() {
//        return Period.between(this.dob, LocalDate.now()).getYears();
//    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", location=" + location +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", accountType=" + accountType +
                ", dietaryRestrictions=" + dietaryRestrictions +
                ", religion=" + religion +
//                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<DietaryRestrictions> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(List<DietaryRestrictions> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
