package com.shaurmaShop.app.controllers;

import com.shaurmaShop.app.models.Ingredient;
import com.shaurmaShop.app.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ingredient> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ingredient -> ResponseEntity.ok().body(ingredient))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return service.save(ingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return service.findById(id)
                .map(existing -> {
                    ingredient.setId(existing.getId());
                    return ResponseEntity.ok().body(service.save(ingredient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}