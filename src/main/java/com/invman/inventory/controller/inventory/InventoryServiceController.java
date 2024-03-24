package com.invman.inventory.controller.inventory;

import com.invman.inventory.model.inventory.InventoryService;
import com.invman.inventory.service.inventory.InventoryServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory/services")
public class InventoryServiceController {
    @Autowired
    InventoryServiceService inventoryServiceService;

    @GetMapping
    public ResponseEntity<?> listAllServices(){
        return ResponseEntity.ok(inventoryServiceService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> newService(@Valid @RequestBody InventoryService inventoryService){
        inventoryServiceService.create(inventoryService);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(@Valid @RequestBody InventoryService inventoryService, @PathVariable  Long id){
        if(!inventoryServiceService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        inventoryServiceService.update(inventoryService, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(inventoryServiceService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}
