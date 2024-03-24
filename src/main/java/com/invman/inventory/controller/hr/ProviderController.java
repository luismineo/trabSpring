package com.invman.inventory.controller.hr;

import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.service.hr.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees/providers")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping
    public ResponseEntity<?> listAllProviders(){
        return ResponseEntity.ok(providerService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> createProvider(@Valid  @RequestBody Provider provider){
        providerService.create(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProvider(@Valid @RequestBody Provider provider, @PathVariable Long id){
        if(!providerService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        providerService.update(provider, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (providerService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}
