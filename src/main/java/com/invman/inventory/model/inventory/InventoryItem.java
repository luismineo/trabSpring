package com.invman.inventory.model.inventory;

import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class InventoryItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private String description;
    private double price;

    public InventoryItem(long ID, String name, String description, double price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public InventoryItem() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
