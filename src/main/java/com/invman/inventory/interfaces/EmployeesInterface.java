package com.invman.inventory.interfaces;

import com.invman.inventory.model.hr.Employee;

import java.util.List;

public interface EmployeesInterface<T extends Employee> {
    T create(T t);
    T update(T t, Long id);

    List<T> listAll();

    boolean verify(Long id);

    boolean delete(Long id);
}
