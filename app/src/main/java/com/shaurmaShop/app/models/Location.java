package com.shaurmaShop.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @OneToMany(mappedBy = "location")
    @JsonManagedReference
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}