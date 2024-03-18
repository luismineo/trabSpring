package com.invman.inventory.model.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InventoryService extends InventoryItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private float estimatedHours;

    public InventoryService(String name, String description, double price, long ID, float estimatedHours) {
        super(name, description, price);
        this.ID = ID;
        this.estimatedHours = estimatedHours;
    }

    public InventoryService(float estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public InventoryService() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public float getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(float estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
