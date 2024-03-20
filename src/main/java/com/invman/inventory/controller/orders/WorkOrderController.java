package com.invman.inventory.controller.orders;

import com.invman.inventory.model.orders.WorkOrder;
import com.invman.inventory.service.orders.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders/works")
public class WorkOrderController {
    @Autowired
    WorkOrderService workOrderService;

    @GetMapping
    public ResponseEntity<List<WorkOrder>> listAll(){
        return ResponseEntity.ok(workOrderService.listAll());
    }

    @PostMapping
    public ResponseEntity<WorkOrder> saveOrder(@RequestBody WorkOrder workOrder){
        return ResponseEntity.ok(workOrderService.create(workOrder));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> updateOrder(@RequestBody WorkOrder workOrder, @PathVariable Long id){
        return ResponseEntity.ok(workOrderService.update(workOrder, id));
    }
}

