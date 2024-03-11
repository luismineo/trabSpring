package com.invman.inventory.model.inventory;

import jakarta.persistence.*;

@Entity
public class InventoryProduct extends InventoryItem{
    private Integer quantityInStock;

    public InventoryProduct(long ID, String name, String description, double price, Integer quantityInStock) {
        super(ID, name, description, price);
        this.quantityInStock = quantityInStock;
    }

    public InventoryProduct(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public InventoryProduct() {

    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
