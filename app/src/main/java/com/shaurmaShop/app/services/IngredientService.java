package com.shaurmaShop.app.services;

import com.shaurmaShop.app.models.Ingredient;
import com.shaurmaShop.app.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Optional<Ingredient> findById(Long id) {
        return repository.findById(id);
    }

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}