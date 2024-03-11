package com.invman.inventory.model.hr;

import jakarta.persistence.Entity;

@Entity
public class Seller extends Employee{
    private float commission;

    public Seller(long ID, String name, String email, float salary, float commission) {
        super(ID, name, email, salary);
        this.commission = commission;
    }

    public Seller(float commission) {
        this.commission = commission;
    }

    public Seller() {

    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
