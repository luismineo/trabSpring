package com.invman.inventory.model.inventory;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class InventoryProduct extends InventoryItem{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;
    @NotNull
    @Column(nullable = false)
    @Min(0)
    private Integer quantityInStock = 0;

    public InventoryProduct(String name, String description, double price, long ID, Integer quantityInStock) {
        super(name, description, price);
        this.ID = ID;
        this.quantityInStock = quantityInStock;
    }

    public InventoryProduct(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public InventoryProduct() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
