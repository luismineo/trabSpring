package com.invman.inventory.service.inventory;

import com.invman.inventory.interfaces.InventoryInterface;
import com.invman.inventory.model.inventory.InventoryProduct;
import com.invman.inventory.repository.inventory.InventoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProductService implements InventoryInterface<InventoryProduct> {
    @Autowired
    InventoryProductRepository inventoryProductRepository;

    @Override
    public InventoryProduct create(InventoryProduct inventoryProduct) {
        return inventoryProductRepository.save(inventoryProduct);
    }

    @Override
    public InventoryProduct update(InventoryProduct inventoryProduct, Long id) {
        if(verify(id)){
            inventoryProduct.setID(id);
            return inventoryProductRepository.save(inventoryProduct);
        }
        return null;
    }

    @Override
    public List<InventoryProduct> listAll() {
        return inventoryProductRepository.findAll();
    }

    @Override
    public boolean verify(Long id) {
        return inventoryProductRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verify(id)){
            inventoryProductRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
