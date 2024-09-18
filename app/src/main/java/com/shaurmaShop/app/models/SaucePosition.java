package com.shaurmaShop.app.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sauce_positions")
public class SaucePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "sauce_ingredients",
            joinColumns = @JoinColumn(name = "sauce_id"),
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}