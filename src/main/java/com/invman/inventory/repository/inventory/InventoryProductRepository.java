package com.invman.inventory.repository.inventory;

import com.invman.inventory.model.inventory.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryProductRepository extends JpaRepository<InventoryProduct, Long> {
}
