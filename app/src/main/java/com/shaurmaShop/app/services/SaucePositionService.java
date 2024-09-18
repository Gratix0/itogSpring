package com.shaurmaShop.app.services;

import com.shaurmaShop.app.models.SaucePosition;
import com.shaurmaShop.app.repositories.SaucePositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaucePositionService {

    private final SaucePositionRepository repository;

    public SaucePositionService(SaucePositionRepository repository) {
        this.repository = repository;
    }

    public List<SaucePosition> findAll() {
        return repository.findAll();
    }

    public Optional<SaucePosition> findById(Long id) {
        return repository.findById(id);
    }

    public SaucePosition save(SaucePosition saucePosition) {
        return repository.save(saucePosition);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}