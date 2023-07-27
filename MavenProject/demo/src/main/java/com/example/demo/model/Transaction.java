package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name="transactions",uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="userId",nullable = false)
    private long userId;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="date",nullable = false)
    private Date date;

}
