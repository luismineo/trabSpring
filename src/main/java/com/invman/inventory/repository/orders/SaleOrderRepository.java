package com.invman.inventory.repository.orders;

import com.invman.inventory.model.orders.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {
}
