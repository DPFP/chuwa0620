package com.chuwa.RewardsProgram.payload;

import java.time.LocalDate;
import java.util.Date;

public class TransactionDto {
    private long id;
    private String title;
    private Double amount;
    private LocalDate date;

    public TransactionDto(long id, String title, Double amount, LocalDate date) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    public TransactionDto(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
