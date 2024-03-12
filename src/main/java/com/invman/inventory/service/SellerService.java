package com.invman.inventory.service;

import com.invman.inventory.model.hr.Seller;
import com.invman.inventory.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public Seller create(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller update(Seller seller, Long id) {
        if(verify(id)){
            seller.setID(id);
            return sellerRepository.save(seller);
        }
        return null;
    }

    public List<Seller> listAll() {
        return sellerRepository.findAll();
    }

    public boolean verify(Long id) {
        return sellerRepository.existsById(id);
    }
}
