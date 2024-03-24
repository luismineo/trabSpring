package com.invman.inventory.model.hr;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Provider extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @NotNull
    @Column(nullable = false)
    private String specialty;

    public Provider(String name, String email, float salary, long ID, String specialty) {
        super(name, email, salary);
        this.ID = ID;
        this.specialty = specialty;
    }

    public Provider() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
