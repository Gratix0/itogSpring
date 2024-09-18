package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}