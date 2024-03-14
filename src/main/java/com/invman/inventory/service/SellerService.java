package com.invman.inventory.service;

import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService implements CrudInterface<Seller>{
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Seller create(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(Seller seller, Long id) {
        if(verify(id)){
            seller.setID(id);
            return sellerRepository.save(seller);
        }
        return null;
    }

    @Override
    public List<Seller> listAll() {
        return sellerRepository.findAll();
    }

    @Override
    public boolean verify(Long id) {
        return sellerRepository.existsById(id);
    }
}
