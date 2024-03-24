package com.invman.inventory.service.inventory;

import com.invman.inventory.interfaces.InventoryInterface;
import com.invman.inventory.model.inventory.InventoryService;
import com.invman.inventory.repository.inventory.InventoryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceService implements InventoryInterface<InventoryService> {
    @Autowired
    InventoryServiceRepository inventoryServiceRepository;

    @Override
    public InventoryService create(InventoryService inventoryService) {
        return inventoryServiceRepository.save(inventoryService);
    }

    @Override
    public InventoryService update(InventoryService inventoryService, Long id) {
        if(verify(id)){
            inventoryService.setID(id);
            return inventoryServiceRepository.save(inventoryService);
        }
        return null;
    }

    @Override
    public List<InventoryService> listAll() {
        return inventoryServiceRepository.findAll();
    }

    @Override
    public boolean verify(Long id) {
        return inventoryServiceRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verify(id)){
            inventoryServiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
