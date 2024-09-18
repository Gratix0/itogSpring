package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}