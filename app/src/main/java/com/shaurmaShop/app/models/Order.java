package com.shaurmaShop.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderTime;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_shawarmas",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "shawarma_id")
    )
    private Set<ShawarmaPosition> shawarmas;

    @ManyToMany
    @JoinTable(
            name = "order_sauces",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "sauce_id")
    )
    private Set<SaucePosition> sauces;

    // _________________________
    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<ShawarmaPosition> getShawarmas() {
        return shawarmas;
    }

    public Set<SaucePosition> getSauces() {
        return sauces;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShawarmas(Set<ShawarmaPosition> shawarmas) {
        this.shawarmas = shawarmas;
    }

    public void setSauces(Set<SaucePosition> sauces) {
        this.sauces = sauces;
    }
}