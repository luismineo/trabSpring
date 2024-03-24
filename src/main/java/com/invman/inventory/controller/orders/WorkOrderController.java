package com.invman.inventory.controller.orders;

import com.invman.inventory.model.orders.WorkOrder;
import com.invman.inventory.service.orders.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> saveOrder(@Valid @RequestBody WorkOrder workOrder){
        workOrderService.create(workOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item successfully registered");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody WorkOrder workOrder, @PathVariable Long id){
        if(!workOrderService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        workOrderService.update(workOrder, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
    }

    @PutMapping("/finalize/{id}")
    public ResponseEntity<?> finalizeWorkOrder(@PathVariable Long id, @RequestParam float hoursWorked){
        if(!workOrderService.verify(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        workOrderService.finalizeWorkOrder(id, hoursWorked);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully finalized");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(workOrderService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
    }
}

