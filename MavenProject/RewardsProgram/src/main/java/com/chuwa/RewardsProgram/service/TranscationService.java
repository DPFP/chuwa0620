package com.chuwa.RewardsProgram.service;

import com.chuwa.RewardsProgram.payload.TransactionDto;

import java.util.List;

public interface TranscationService {
    TransactionDto createTransaction(long userId, TransactionDto transactionDto);
    List<TransactionDto> getTransactionsByUserId(long userId);
    TransactionDto getTransactionById(long userId, long transactionId);
    void deleteTransaction(long userId, long transactionId);
}
