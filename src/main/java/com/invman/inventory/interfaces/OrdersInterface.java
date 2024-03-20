package com.invman.inventory.interfaces;

import com.invman.inventory.model.orders.BaseOrder;

import java.util.List;

public interface OrdersInterface <T extends BaseOrder>{
    T create(T t);
    T update(T t, Long id);

    List<T> listAll();

    boolean verify(Long id);

    boolean delete(Long id);
}
