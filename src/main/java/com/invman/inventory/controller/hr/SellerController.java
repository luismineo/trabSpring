package com.invman.inventory.controller.hr;

import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @GetMapping
    public ResponseEntity<?> listAllSellers(){
        return new ResponseEntity<>(sellerService.listAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSeller(@RequestBody Seller seller){
        return new ResponseEntity<>(sellerService.create(seller), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller, @PathVariable Long id){
        return new ResponseEntity<>(sellerService.update(seller, id), HttpStatus.OK);
    }
}