package com.invman.inventory.model.hr;

import jakarta.persistence.Entity;

@Entity
public class Provider extends Employee{
    private String specialty;

    public Provider(long ID, String name, String email, float salary, String specialty) {
        super(ID, name, email, salary);
        this.specialty = specialty;
    }

    public Provider(String specialty) {
        this.specialty = specialty;
    }

    public Provider() {

    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
