package com.invman.inventory.model.hr;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Employee {
    @NotNull
    @Column(nullable = false)
    private String name;
    private String email;
    @NotNull
    @Column(nullable = false)
    private float salary;

    public Employee(String name, String email, float salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}