package com.shaurmaShop.app.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shawarma_positions")
public class ShawarmaPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "shawarma_ingredients",
            joinColumns = @JoinColumn(name = "shawarma_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}