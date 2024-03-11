package com.invman.inventory.service;

import com.invman.inventory.model.hr.Employee;
import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private boolean verify(Long id) {
        return employeeRepository.existsById(id);
    }

    public Seller createSeller(Seller seller) {
        return employeeRepository.save(seller);
    }

    public Provider createProvider(Provider provider) {
        return employeeRepository.save(provider);
    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Seller updateSeller(Seller seller, Long id) {
        if(verify(id)){
            seller.setID(id);
            return employeeRepository.save(seller);
        }
        return null;
    }

    public Provider updateProvider(Provider provider, Long id) {
        if(verify(id)){
            provider.setID(id);
            return employeeRepository.save(provider);
        }
        return null;
    }
}