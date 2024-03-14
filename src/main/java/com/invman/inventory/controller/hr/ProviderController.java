package com.invman.inventory.controller.hr;

import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees/providers")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping
    public ResponseEntity<?> listAllProviders(){
        return new ResponseEntity<>(providerService.listAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProvider(@RequestBody Provider provider){
        return new ResponseEntity<>(providerService.create(provider), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProvider(@RequestBody Provider provider, @PathVariable Long id){
        return new ResponseEntity<>(providerService.update(provider, id), HttpStatus.OK);
    }

}