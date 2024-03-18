package com.invman.inventory.controller.orders;

import com.invman.inventory.model.orders.SaleOrder;
import com.invman.inventory.service.inventory.InventoryProductService;
import com.invman.inventory.service.orders.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders/sale")
public class SaleOrderController {
    @Autowired
    SaleOrderService saleOrderService;

    @GetMapping
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(saleOrderService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> newSaleOrder(@RequestBody SaleOrder saleOrder){
        return ResponseEntity.ok(saleOrderService.create(saleOrder));
    }
}
