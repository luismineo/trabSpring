package com.invman.inventory.repository.orders;

import com.invman.inventory.model.orders.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {
}
