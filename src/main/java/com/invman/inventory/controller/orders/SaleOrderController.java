package com.invman.inventory.controller.orders;

import com.invman.inventory.model.orders.SaleOrder;
import com.invman.inventory.service.orders.SaleOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> newSaleOrder(@Valid @RequestBody SaleOrder saleOrder){
        saleOrderService.create(saleOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody SaleOrder saleOrder, @PathVariable Long id){
        if(!saleOrderService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        saleOrderService.update(saleOrder, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(saleOrderService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}
