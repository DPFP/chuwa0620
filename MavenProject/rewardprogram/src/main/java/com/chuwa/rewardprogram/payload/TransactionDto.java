package com.chuwa.rewardprogram.payload;

public class TransactionDto {

    private long id;
    private String purchaseTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionDto(){

    }

    public TransactionDto(long id, String purchaseTime, int amount) {
        this.id = id;
        this.purchaseTime = purchaseTime;
        this.amount = amount;
    }

    private int amount;
}
