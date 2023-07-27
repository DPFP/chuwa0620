package com.example.project.payload;

import com.example.project.entity.Transaction;
import java.util.HashSet;
import java.util.Set;

public class CustomerDto {
    private Long id;
    private String name;
    private Set<Transaction> transactions = new HashSet<>();

    public CustomerDto() {}

    public CustomerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
