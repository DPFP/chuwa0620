package com.example.coding1reward.service.impl;

import com.example.coding1reward.dao.CustomerRepository;
import com.example.coding1reward.dao.TransactionRepository;
import com.example.coding1reward.entity.Customer;
import com.example.coding1reward.entity.Transaction;
import com.example.coding1reward.exception.ResourceNotFoundException;
import com.example.coding1reward.payload.TransactionDto;
import com.example.coding1reward.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private ModelMapper modelMapper;

    @Override
    public TransactionDto createTransaction(long customerId, TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        transaction.setCustomer(customer);
        Transaction savedTransaction = this.transactionRepository.save(transaction);
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getTransactionsByCustomerId(long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        return transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getTransactionsById(long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public void deleteTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        this.transactionRepository.delete(transaction);
    }
}
