package com.shaurmaShop.app.controllers;

import com.shaurmaShop.app.models.Supplier;
import com.shaurmaShop.app.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping
    public List<Supplier> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(supplier -> ResponseEntity.ok().body(supplier))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return service.save(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return service.findById(id)
                .map(existing -> {
                    supplier.setId(existing.getId());
                    return ResponseEntity.ok().body(service.save(supplier));
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