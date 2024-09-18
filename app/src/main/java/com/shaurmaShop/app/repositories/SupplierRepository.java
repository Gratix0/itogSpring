package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}