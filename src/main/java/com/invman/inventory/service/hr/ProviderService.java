package com.invman.inventory.service.hr;

import com.invman.inventory.model.hr.Provider;
import com.invman.inventory.repository.hr.ProviderRepository;
import com.invman.inventory.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService implements CrudInterface<Provider> {
    @Autowired
    ProviderRepository providerRepository;

    @Override
    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider update(Provider provider, Long id) {
        if(verify(id)){
            provider.setID(id);
            return providerRepository.save(provider);
        }
        return null;
    }

    @Override
    public List<Provider> listAll() {
        return providerRepository.findAll();
    }

    @Override
    public boolean verify(Long id) {
        return providerRepository.existsById(id);
    }
}
