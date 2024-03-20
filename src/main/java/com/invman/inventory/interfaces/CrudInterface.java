package com.invman.inventory.interfaces;

import com.invman.inventory.model.BaseModel;

import java.util.List;

public interface CrudInterface <T extends BaseModel> {
    T create(T t);
    T update(T t, Long id);

    List<T> listAll();

    boolean verify(Long id);
}
