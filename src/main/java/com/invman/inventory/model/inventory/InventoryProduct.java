package com.invman.inventory.model.inventory;

import jakarta.persistence.*;

@Entity
public class InventoryProduct extends InventoryItem{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;
    private Integer quantityInStock;

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
