package com.example.coding1reward.service;

import com.example.coding1reward.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(long customerId, TransactionDto transactionDto);
    List<TransactionDto> getTransactionsByCustomerId(long customerId);
    TransactionDto getTransactionsById(long transactionId);
    void deleteTransactionById(long id);
}
