package com.invman.inventory.service.orders;

import com.invman.inventory.interfaces.OrdersInterface;
import com.invman.inventory.model.orders.SaleOrder;
import com.invman.inventory.repository.orders.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderService implements OrdersInterface<SaleOrder> {
    @Autowired
    SaleOrderRepository saleOrderRepository;

    @Override
    public SaleOrder create(SaleOrder saleOrder) {
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

    @Override
    public boolean delete(Long id) {
        return false;
    }

}
