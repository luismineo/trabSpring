package com.invman.inventory.interfaces;

import com.invman.inventory.model.inventory.InventoryItem;

import java.util.List;

public interface InventoryInterface <T extends InventoryItem> {
    T create(T t);
    T update(T t, Long id);

    List<T> listAll();

    boolean verify(Long id);

    boolean delete(Long id);
}
