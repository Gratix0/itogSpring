package com.shaurmaShop.app.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {

    public Set<Ingredient> getIngredientsSupplied() {
        return ingredientsSupplied;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactInfo;

    @ManyToMany
    @JoinTable(
            name = "supplier_ingredients",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredientsSupplied;

    //_________________________
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setIngredientsSupplied(Set<Ingredient> ingredientsSupplied) {
        this.ingredientsSupplied = ingredientsSupplied;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}