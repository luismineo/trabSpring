package com.invman.inventory.model.orders;

import com.invman.inventory.model.BaseModel;
import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.model.inventory.InventoryService;
import jakarta.persistence.*;

@Entity
public class WorkOrder extends BaseModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "inventoryService_id")
    private InventoryService service;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    private float hoursWorked;
    private double totalPrice;

    public WorkOrder(long id, InventoryService service, Provider provider, float hoursWorked, double totalPrice) {
        this.id = id;
        this.service = service;
        this.provider = provider;
        this.hoursWorked = hoursWorked;
        this.totalPrice = totalPrice;
    }

    public WorkOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InventoryService getService() {
        return service;
    }

    public void setService(InventoryService service) {
        this.service = service;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
