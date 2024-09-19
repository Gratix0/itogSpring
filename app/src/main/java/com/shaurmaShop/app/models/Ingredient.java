package com.shaurmaShop.app.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // Например, "shawarma" или "sauce"

    @ManyToMany(mappedBy = "ingredients")
    private Set<ShawarmaPosition> shawarmas;

    @ManyToMany(mappedBy = "ingredients")
    private Set<SaucePosition> sauces;

    //_________________________

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShawarmas(Set<ShawarmaPosition> shawarmas) {
        this.shawarmas = shawarmas;
    }

    public void setSauces(Set<SaucePosition> sauces) {
        this.sauces = sauces;
    }
}