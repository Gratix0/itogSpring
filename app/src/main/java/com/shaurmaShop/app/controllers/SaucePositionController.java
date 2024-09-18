package com.shaurmaShop.app.controllers;

import com.shaurmaShop.app.models.SaucePosition;
import com.shaurmaShop.app.services.SaucePositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sauces")
public class SaucePositionController {

    private final SaucePositionService service;

    public SaucePositionController(SaucePositionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SaucePosition> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaucePosition> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(sauce -> ResponseEntity.ok().body(sauce))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SaucePosition create(@RequestBody SaucePosition saucePosition) {
        return service.save(saucePosition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaucePosition> update(@PathVariable Long id, @RequestBody SaucePosition saucePosition) {
        return service.findById(id)
                .map(existing -> {
                    saucePosition.setId(existing.getId());
                    return ResponseEntity.ok().body(service.save(saucePosition));
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