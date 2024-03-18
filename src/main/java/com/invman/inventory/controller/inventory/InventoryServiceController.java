package com.invman.inventory.controller.inventory;

import com.invman.inventory.model.inventory.InventoryService;
import com.invman.inventory.service.inventory.InventoryServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<?> newService(InventoryService inventoryService){
        return ResponseEntity.ok(inventoryServiceService.create(inventoryService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(InventoryService inventoryService, Long id){
        return ResponseEntity.ok(inventoryServiceService.update(inventoryService, id));
    }
}
