package com.invman.inventory.service;

import com.invman.inventory.model.hr.Seller;

import java.util.List;

public interface CrudInterface <T> {
    T create(T object);
    T update(T object, Long id);

    List<T> listAll();

    boolean verify(Long id);
}
