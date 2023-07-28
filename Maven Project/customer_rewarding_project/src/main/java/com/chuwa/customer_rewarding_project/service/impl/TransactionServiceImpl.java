package com.chuwa.customer_rewarding_project.service.impl;

import com.chuwa.customer_rewarding_project.dao.CustomerRepository;
import com.chuwa.customer_rewarding_project.dao.TransactionRepository;
import com.chuwa.customer_rewarding_project.entity.Customer;
import com.chuwa.customer_rewarding_project.entity.Transaction;
import com.chuwa.customer_rewarding_project.exception.ResourceNotFoundException;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsDto;
import com.chuwa.customer_rewarding_project.payload.TransactionCreatedResponseDto;
import com.chuwa.customer_rewarding_project.payload.TransactionDto;
import com.chuwa.customer_rewarding_project.service.RewardingPointsService;
import com.chuwa.customer_rewarding_project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final RewardingPointsService rewardingPointsService;

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
        RewardingPointsDto rewardingPointsDto = this.rewardingPointsService.createRewardingPoints(customerId, transactionDto);
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
        return transactions.stream().map(TransactionServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getTransactionsById(long transactionId) {
        Transaction transaction = this.transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        return mapToDto(transaction);
    }

    @Override
    public void deleteTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        this.transactionRepository.delete(transaction);
    }
}
