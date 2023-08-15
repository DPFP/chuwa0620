package com.example.demo.service.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.RewardsRepository;
import com.example.demo.dao.TransactionRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Transaction;
import com.example.demo.payload.RewardDto;
import com.example.demo.payload.TransactionCreatedResponseDto;
import com.example.demo.payload.TransactionDto;
import com.example.demo.service.RewardService;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final RewardService rewardService;
    private final ModelMapper modelMapper;

    private static TransactionDto mapToDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }
    @Override
    public TransactionCreatedResponseDto createTransaction(long customerId, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());

        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        transaction.setCustomer(customer);

        // Create rewarding points at the same time
        RewardDto rewardingPointsDto = this.rewardService.createRewardingPoints(customerId, transactionDto);
        Transaction savedTransaction = this.transactionRepository.save(transaction);

        // Map to the response object
        TransactionCreatedResponseDto responseDto = new TransactionCreatedResponseDto();
        responseDto.setId(savedTransaction.getId());
        responseDto.setAmount(savedTransaction.getAmount());
        responseDto.setRewardingPointsGained(rewardingPointsDto.getAmount());

        return responseDto;
    }

    @Override
    public List<TransactionDto> getTransactionsByCustomerId(long customerId) {
        this.customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        return transactions.stream().map(t->modelMapper.map(t,TransactionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getTransactionsById(long transactionId) {
        Transaction transaction = this.transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        return modelMapper.map(transaction,TransactionDto.class);
    }

    @Override
    public void deleteTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        this.transactionRepository.delete(transaction);
    }
}
