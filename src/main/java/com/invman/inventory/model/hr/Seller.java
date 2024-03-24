package com.invman.inventory.model.hr;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

@Entity
public class Seller extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @NotNull
    @Column(nullable = false)
    @Max(1)
    private float commission;

    public Seller(String name, String email, float salary, long ID, float commission) {
        super(name, email, salary);
        this.ID = ID;
        this.commission = commission;
    }

    public Seller(long ID, float commission) {
        this.ID = ID;
        this.commission = commission;
    }

    public Seller() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
