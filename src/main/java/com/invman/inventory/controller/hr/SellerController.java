package com.invman.inventory.controller.hr;

import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.service.hr.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @GetMapping
    public ResponseEntity<?> listAllSellers(){
        return ResponseEntity.ok(sellerService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> createSeller(@Valid @RequestBody Seller seller){
        sellerService.create(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeller(@Valid @RequestBody Seller seller, @PathVariable Long id){
        if(!sellerService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        sellerService.update(seller, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (sellerService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}