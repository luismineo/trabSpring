package com.invman.inventory.service.orders;

import com.invman.inventory.interfaces.OrdersInterface;
import com.invman.inventory.model.inventory.InventoryService;
import com.invman.inventory.model.orders.WorkOrder;
import com.invman.inventory.repository.inventory.InventoryServiceRepository;
import com.invman.inventory.repository.orders.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService implements OrdersInterface<WorkOrder> {
    @Autowired
    WorkOrderRepository workOrderRepository;

    @Autowired
    InventoryServiceRepository inventoryServiceRepository;

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        //Busca o serviço na DB
        InventoryService service = inventoryServiceRepository.findById(workOrder.getService().getID()).orElseThrow(()
                -> new RuntimeException("Product not found")); //Se não encontrar o produto, lança uma exceção

        //Calcula o preço estimado
        double estimatedTotalPrice = service.getEstimatedHours() * service.getPrice();
        workOrder.setTotalPrice(estimatedTotalPrice);

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

    public void finalizeWorkOrder(Long id, float hoursWorked) {
        if(verify(id)){
            //Busca o serviço na DB
            WorkOrder workOrder = workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Work Order not found"));

            //Seta o status como completo
            workOrder.setStatus(WorkOrder.Status.COMPLETED);

            //Calucula o novo preço total
            workOrder.setHoursWorked(hoursWorked);
            workOrder.setTotalPrice((workOrder.getService().getPrice()) * (workOrder.getHoursWorked()));

            workOrderRepository.save(workOrder);
        }
    }
}
