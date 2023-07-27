package com.example.project.payload;

import com.example.project.entity.Customer;
import com.example.project.entity.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TransactionDto {

    private Long id;
    private LocalDate date;
    private Set<Product> products = new HashSet<>();
    public TransactionDto() {}

    public TransactionDto(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
