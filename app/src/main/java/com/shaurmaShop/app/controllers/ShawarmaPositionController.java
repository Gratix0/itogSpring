package com.shaurmaShop.app.controllers;

import com.shaurmaShop.app.models.ShawarmaPosition;
import com.shaurmaShop.app.services.ShawarmaPositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shawarmas")
public class ShawarmaPositionController {

    private final ShawarmaPositionService service;

    public ShawarmaPositionController(ShawarmaPositionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShawarmaPosition> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShawarmaPosition> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(shawarma -> ResponseEntity.ok().body(shawarma))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShawarmaPosition create(@RequestBody ShawarmaPosition shawarmaPosition) {
        return service.save(shawarmaPosition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShawarmaPosition> update(@PathVariable Long id, @RequestBody ShawarmaPosition shawarmaPosition) {
        return service.findById(id)
                .map(existing -> {
                    shawarmaPosition.setId(existing.getId());
                    return ResponseEntity.ok().body(service.save(shawarmaPosition));
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