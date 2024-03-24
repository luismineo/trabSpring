package com.invman.inventory.service.orders;

import com.invman.inventory.interfaces.OrdersInterface;
import com.invman.inventory.model.orders.WorkOrder;
import com.invman.inventory.repository.orders.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService implements OrdersInterface<WorkOrder> {
    @Autowired
    WorkOrderRepository workOrderRepository;

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        //Calcula o preço total
        workOrder.setTotalPrice((workOrder.getService().getPrice()) * (workOrder.getHoursWorked()));

        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder update(WorkOrder workOrder, Long id) {
        if(verify(id)){
            workOrder.setId(id);
            return workOrderRepository.save(workOrder);
        }
        return null;
    }

    @Override
    public List<WorkOrder> listAll() {
        return workOrderRepository.findAll();
    }

    @Override
    public boolean verify(Long id) {
        return workOrderRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verify(id)){
            workOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
