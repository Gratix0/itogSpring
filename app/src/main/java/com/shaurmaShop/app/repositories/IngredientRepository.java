package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}