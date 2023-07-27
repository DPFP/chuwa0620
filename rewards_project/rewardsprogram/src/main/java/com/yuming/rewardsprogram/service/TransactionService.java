package com.yuming.rewardsprogram.service;

import com.yuming.rewardsprogram.dto.TransactionDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(Long customerId, TransactionDto transactionDto);
    TransactionDto updateTransaction(Long id, TransactionDto transactionDto);
    void deleteTransaction(Long id);
    TransactionDto getTransactionById(Long id, Long customerId);
    List<TransactionDto> getAllTransactionsByCustomerId(Long customerId);
    List<TransactionDto> getCustomerTransactionsInLastThreeMonths(Long customerId);
    List<TransactionDto> getAllTransactionsByCustomerIdAndTimeRange(Long customerId, LocalDateTime startTime, LocalDateTime endTime);

}
