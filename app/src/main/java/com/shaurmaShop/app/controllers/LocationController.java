package com.shaurmaShop.app.controllers;

import com.shaurmaShop.app.models.Location;
import com.shaurmaShop.app.services.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Location> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(location -> ResponseEntity.ok().body(location))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        return service.save(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location) {
        return service.findById(id)
                .map(existing -> {
                    location.setId(existing.getId());
                    return ResponseEntity.ok().body(service.save(location));
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