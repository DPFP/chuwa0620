package com.example.Rewards.Program.service;

import com.example.Rewards.Program.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(long customerId, TransactionDto transactionDto);
    List<TransactionDto> getAllTransactions();
    TransactionDto getTransactionById(long id);
    TransactionDto updateTransactionById(long id, TransactionDto transactionDto);
    void deleteTransactionById(long id);
}
