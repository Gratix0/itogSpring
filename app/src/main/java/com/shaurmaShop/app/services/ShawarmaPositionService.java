package com.shaurmaShop.app.services;

import com.shaurmaShop.app.models.ShawarmaPosition;
import com.shaurmaShop.app.repositories.ShawarmaPositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShawarmaPositionService {

    private final ShawarmaPositionRepository repository;

    public ShawarmaPositionService(ShawarmaPositionRepository repository) {
        this.repository = repository;
    }

    public List<ShawarmaPosition> findAll() {
        return repository.findAll();
    }

    public Optional<ShawarmaPosition> findById(Long id) {
        return repository.findById(id);
    }

    public ShawarmaPosition save(ShawarmaPosition shawarmaPosition) {
        return repository.save(shawarmaPosition);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}