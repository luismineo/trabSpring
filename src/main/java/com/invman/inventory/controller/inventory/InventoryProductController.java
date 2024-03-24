package com.invman.inventory.controller.inventory;

import com.invman.inventory.model.inventory.InventoryProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.invman.inventory.service.inventory.InventoryProductService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> newProduct(@Valid @RequestBody InventoryProduct inventoryProduct){
        inventoryProductService.create(inventoryProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody InventoryProduct inventoryProduct, @PathVariable Long id){
        if(!inventoryProductService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        inventoryProductService.update(inventoryProduct, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(inventoryProductService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}
