package com.invman.inventory.service;

import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider update(Provider provider, Long id) {
        if(verify(id)){
            provider.setID(id);
            return providerRepository.save(provider);
        }
        return null;
    }

    public List<Provider> listAll() {
        return providerRepository.findAll();
    }

    public boolean verify(Long id) {
        return providerRepository.existsById(id);
    }
}
