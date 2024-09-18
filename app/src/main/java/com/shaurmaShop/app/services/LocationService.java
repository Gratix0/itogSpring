package com.shaurmaShop.app.services;

import com.shaurmaShop.app.models.Location;
import com.shaurmaShop.app.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Optional<Location> findById(Long id) {
        return repository.findById(id);
    }

    public Location save(Location location) {
        return repository.save(location);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}