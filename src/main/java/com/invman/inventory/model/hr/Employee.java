package com.invman.inventory.model.hr;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

//@Entity
//@Inheritance (strategy = InheritanceType.JOINED)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Seller.class, name = "seller"),
//        @JsonSubTypes.Type(value = Provider.class, name = "provider")
//})
@MappedSuperclass
public abstract class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private String email;
    private float salary;

    public Employee(long ID, String name, String email, float salary) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Employee() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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