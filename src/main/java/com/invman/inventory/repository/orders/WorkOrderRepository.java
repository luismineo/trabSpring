package com.invman.inventory.repository.orders;

import com.invman.inventory.model.orders.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
