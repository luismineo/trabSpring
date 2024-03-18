package com.invman.inventory.controller.inventory;

import com.invman.inventory.model.inventory.InventoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import com.invman.inventory.service.inventory.InventoryProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory/products")
public class InventoryProductController {
    @Autowired
    InventoryProductService inventoryProductService;

    @GetMapping
    public ResponseEntity<?> listAllProducts(){
        return ResponseEntity.ok(inventoryProductService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> newProduct(@RequestBody InventoryProduct inventoryProduct){
        return ResponseEntity.ok(inventoryProductService.create(inventoryProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody InventoryProduct inventoryProduct, @PathVariable Long id){
        return ResponseEntity.ok(inventoryProductService.update(inventoryProduct, id));
    }
}
