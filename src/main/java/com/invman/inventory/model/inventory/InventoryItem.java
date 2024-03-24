package com.invman.inventory.model.inventory;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

//@Entity
//@Inheritance (strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class InventoryItem {
    @NotNull
    @Column(nullable = false)
    private String name;
    private String description;
    @NotNull
    @Column(nullable = false)
    @Min(1)
    private double price;

    public InventoryItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public InventoryItem() {
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
