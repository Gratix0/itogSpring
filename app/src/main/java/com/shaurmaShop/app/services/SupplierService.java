package com.shaurmaShop.app.services;

import com.shaurmaShop.app.models.Supplier;
import com.shaurmaShop.app.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> findAll() {
        return repository.findAll();
    }

    public Optional<Supplier> findById(Long id) {
        return repository.findById(id);
    }

    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}