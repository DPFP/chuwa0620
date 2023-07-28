package com.yuming.rewardsprogram.service.impl;

import com.yuming.rewardsprogram.dao.CustomerRepo;
import com.yuming.rewardsprogram.dao.TransactionRepo;
import com.yuming.rewardsprogram.dto.TransactionDto;
import com.yuming.rewardsprogram.entity.Customer;
import com.yuming.rewardsprogram.entity.Transaction;
import com.yuming.rewardsprogram.exception.ResourceNotFoundException;
import com.yuming.rewardsprogram.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;
    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepo transactionRepo, CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.transactionRepo = transactionRepo;
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDto createTransaction(Long customerId, TransactionDto transactionDto) {
        Customer customer = customerRepo.findById(customerId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction.setCustomer(customer);
        Transaction savedTransaction = transactionRepo.save(transaction);
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }



    @Override
    public TransactionDto updateTransaction(Long id, TransactionDto transactionDto) {
        Transaction existingTransaction = transactionRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));

        existingTransaction.setAmount(transactionDto.getAmount());
        existingTransaction = transactionRepo.save(existingTransaction);

        return modelMapper.map(existingTransaction, TransactionDto.class);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction existingTransaction = transactionRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));

        transactionRepo.delete(existingTransaction);

    }

    @Override
    public TransactionDto getTransactionById(Long id, Long customerId) {
        Transaction transaction = transactionRepo.findByIdAndCustomerId(id, customerId)
                                                 .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));

        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransactionsByCustomerId(Long customerId) {
        List<Transaction> transactions = transactionRepo.findByCustomerId(customerId);
        return transactions.stream()
                           .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                           .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDto> getCustomerTransactionsInLastThreeMonths(Long customerId) {
        LocalDateTime endDateTime = LocalDateTime.now();
        LocalDateTime startDateTime = endDateTime.minusMonths(3);
        return getAllTransactionsByCustomerIdAndTimeRange(customerId, startDateTime, endDateTime);
    }

    @Override
    public List<TransactionDto> getAllTransactionsByCustomerIdAndTimeRange(Long customerId, LocalDateTime startTime, LocalDateTime endTime) {
        List<Transaction> transactions = transactionRepo.findByCustomerIdAndCreateDateTimeBetween(customerId, startTime, endTime);
        return transactions.stream()
                           .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                           .collect(Collectors.toList());
    }
}
