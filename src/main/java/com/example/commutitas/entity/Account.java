package com.example.commutitas.entity;

import com.example.commutitas.enums.AccountType;
import com.example.commutitas.enums.DietaryRestrictions;
import com.example.commutitas.enums.Religion;

import java.time.LocalDate;
import java.util.List;

public class Account {

    public String name;
    public AccountType accountType;
    public List<DietaryRestrictions> dietaryRestrictions;
    public Religion religion;

    private LocalDate dob;

    public Account() {
    }

    public Account(
            String name,
            AccountType accountType,
            List<DietaryRestrictions> dietaryRestrictions,
            Religion religion,
            LocalDate dob) {
        this.name = name;
        this.accountType = accountType;
        this.dietaryRestrictions = dietaryRestrictions;
        this.religion = religion;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountType=" + accountType +
                ", dietaryRestrictions=" + dietaryRestrictions +
                ", religion=" + religion +
                ", dob=" + dob +
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
