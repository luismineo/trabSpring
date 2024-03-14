package com.invman.inventory.service;

import com.invman.inventory.model.hr.Employee;
import com.invman.inventory.model.hr.Seller;

import java.util.List;

public interface CrudInterface <T> {
    T create(T t);
    T update(T t, Long id);

    List<T> listAll();

    boolean verify(Long id);
}
