package com.invman.inventory.service.orders;

import com.invman.inventory.interfaces.OrdersInterface;
import com.invman.inventory.model.inventory.InventoryProduct;
import com.invman.inventory.model.orders.SaleOrder;
import com.invman.inventory.repository.inventory.InventoryProductRepository;
import com.invman.inventory.repository.orders.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderService implements OrdersInterface<SaleOrder> {
    @Autowired
    SaleOrderRepository saleOrderRepository;

    @Autowired
    InventoryProductRepository inventoryProductRepository;

    @Override
    public SaleOrder create(SaleOrder saleOrder) {
        //Busca o produto na DB
        InventoryProduct product = inventoryProductRepository.findById(saleOrder.getProduct().getID()).orElseThrow(()
                -> new RuntimeException("Product not found")); //Se não encontrar o produto, lança uma exceção

        //Calcula o preço total
        float productPrice = (float) product.getPrice();
        double totalPrice = saleOrder.getQuantitySold() * productPrice;
        saleOrder.setTotalPrice(totalPrice);

        //Atualiza a quantidade em estoque
        int quantityInStock = product.getQuantityInStock();
        product.setQuantityInStock(quantityInStock - saleOrder.getQuantitySold());

        //Salva o produto atualizado
        inventoryProductRepository.save(product);

        //Seta o produto na ordem de venda
        saleOrder.setProduct(product);

        return saleOrderRepository.save(saleOrder);
    }

    @Override
    public List<SaleOrder> listAll() {
        return saleOrderRepository.findAll();
    }

    @Override
    public SaleOrder update(SaleOrder saleOrder, Long id) {
        if(verify(id)){
            saleOrder.setId(id);
            return saleOrderRepository.save(saleOrder);
        }
        return null;
    }

    @Override
    public boolean verify(Long id) {
        return saleOrderRepository.existsById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(verify(id)){
            SaleOrder saleOrder = findById(id);
            //Retorna a quantidade vendida ao estoque
            saleOrder.getProduct().setQuantityInStock(saleOrder.getProduct().getQuantityInStock() + saleOrder.getQuantitySold());
            saleOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public SaleOrder findById(Long id){
        return saleOrderRepository.getReferenceById(id);
    }
}