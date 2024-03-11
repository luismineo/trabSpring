package com.invman.inventory.model.inventory;

import jakarta.persistence.Entity;

@Entity
public class InventoryService extends InventoryItem{
    private float estimatedHours;

    public InventoryService(long ID, String name, String description, double price, float estimatedHours) {
        super(ID, name, description, price);
        this.estimatedHours = estimatedHours;
    }

    public InventoryService(float estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public InventoryService() {

    }

    public float getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(float estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
