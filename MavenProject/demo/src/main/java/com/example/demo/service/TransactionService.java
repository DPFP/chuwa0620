package com.example.demo.service;

import com.example.demo.payload.TransactionCreatedResponseDto;
import com.example.demo.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionCreatedResponseDto createTransaction(long customerId, TransactionDto transactionDto);
    List<TransactionDto> getTransactionsByCustomerId(long customerId);
    TransactionDto getTransactionsById(long transactionId);
    void deleteTransactionById(long id);
}
