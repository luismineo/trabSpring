package com.invman.inventory.repository.inventory;

import com.invman.inventory.model.inventory.InventoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryServiceRepository extends JpaRepository<InventoryService, Long>{
}
