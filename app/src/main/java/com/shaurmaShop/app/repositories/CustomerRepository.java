package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}