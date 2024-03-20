package com.invman.inventory.model.orders;

import com.invman.inventory.model.BaseModel;
import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.model.inventory.InventoryProduct;
import jakarta.persistence.*;

@Entity
public class SaleOrder extends BaseOrder {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private InventoryProduct product;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    private int quantitySold;
    private double totalPrice;

    public SaleOrder(long id, InventoryProduct product, Seller seller, int quantitySold, double totalPrice) {
        this.id = id;
        this.product = product;
        this.seller = seller;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
    }

    public SaleOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InventoryProduct getProduct() {
        return product;
    }

    public void setProduct(InventoryProduct product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getProductId(){
        return product.getID();
    }
}
