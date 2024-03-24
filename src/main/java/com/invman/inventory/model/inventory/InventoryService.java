package com.invman.inventory.model.inventory;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class InventoryService extends InventoryItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @NotNull
    @Column(nullable = false)
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
