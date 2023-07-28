package com.chuwa.customer_rewarding_project.service;

import com.chuwa.customer_rewarding_project.payload.TransactionCreatedResponseDto;
import com.chuwa.customer_rewarding_project.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionCreatedResponseDto createTransaction(long customerId, TransactionDto transactionDto);
    List<TransactionDto> getTransactionsByCustomerId(long customerId);
    TransactionDto getTransactionsById(long transactionId);
    void deleteTransactionById(long id);
}
