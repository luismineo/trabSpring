package com.invman.inventory.service.orders;

import com.invman.inventory.interfaces.CrudInterface;
import com.invman.inventory.model.orders.SaleOrder;
import com.invman.inventory.repository.orders.SaleOrderRepository;
import com.invman.inventory.service.inventory.InventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderService implements CrudInterface<SaleOrder> {
    @Autowired
    SaleOrderRepository saleOrderRepository;

    @Autowired
    InventoryProductService inventoryProductService;

    @Override
    public SaleOrder create(SaleOrder saleOrder) {
        saleOrder.setProduct(inventoryProductService.getProduct(saleOrder.getProductId()));
        double totalPrice = saleOrder.getQuantitySold() * saleOrder.getProduct().getPrice();
        saleOrder.setTotalPrice(totalPrice);
        return saleOrderRepository.save(saleOrder);
    }

    @Override
    public List<SaleOrder> listAll() {
        return saleOrderRepository.findAll();
    }

    @Override
    public SaleOrder update(SaleOrder saleOrder, Long id) {
        if(verify(id)){
            saleOrder.setId(id);
            return saleOrderRepository.save(saleOrder);
        }
        return null;
    }

    @Override
    public boolean verify(Long id) {
        return saleOrderRepository.existsById(id);
    }

}
