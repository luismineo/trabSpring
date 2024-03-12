package com.invman.inventory.controller.hr;

import com.invman.inventory.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/employees/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @GetMapping
    public ResponseEntity<?> listAllSellers(){
        return new ResponseEntity<>(sellerService.listAll(), HttpStatus.OK);
    }
}
