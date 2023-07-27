package com.chuwa.rewardprogram.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
        name="transaction"
)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "purchase_time", nullable = false)
    private String purchaseTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Transaction() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transaction(long id, int amount, String purchaseTime) {
        this.id = id;
        this.amount = amount;
        this.purchaseTime = purchaseTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
