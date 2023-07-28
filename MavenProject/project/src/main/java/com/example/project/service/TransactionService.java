package com.example.project.service;

import com.example.project.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(Long customerId, TransactionDto transactionDto);
    List<TransactionDto> getAllTransactions();
    List<TransactionDto> getAllTransactionsByCustomerId(Long customerId);
    TransactionDto getTransactionById(Long customerId, Long transactionId);
    void deleteTransactionById(Long customerId, Long transactionId);

    TransactionDto deleteProductsInTransactionByProductIds(List<Long> productIds, Long customerId, Long transactionId);
    TransactionDto addProductsToTransactionByProductIds(List<Long> productIds, Long customerId, Long transactionId);
}
