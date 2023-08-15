package com.example.Rewards.Program.service.impl;

import com.example.Rewards.Program.dao.CustomerRepository;
import com.example.Rewards.Program.dao.PointRepository;
import com.example.Rewards.Program.dao.TransactionRepository;
import com.example.Rewards.Program.entity.Customer;
import com.example.Rewards.Program.entity.Point;
import com.example.Rewards.Program.entity.Transaction;
import com.example.Rewards.Program.exception.ResourceNotFoundException;
import com.example.Rewards.Program.payload.PointDto;
import com.example.Rewards.Program.payload.TransactionDto;
import com.example.Rewards.Program.service.PointService;
import com.example.Rewards.Program.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    private CustomerRepository customerRepository;
    private PointRepository pointRepository;
    private PointService pointService;

    @Override
    public TransactionDto createTransaction(long customerId, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("customer", "id", customerId));
        transaction.setCustomer(customer);
        PointDto newPoint = pointService.createPoint(customerId,transactionDto);
        Point point = pointRepository.findById(newPoint.getId()).orElseThrow(()-> new ResourceNotFoundException("point", "id", newPoint.getId()));
        transaction.setPoint(point);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return mapToDto(savedTransaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = transactions.stream().map(this::mapToDto).toList();
        return transactionDtos;
    }

    @Override
    public TransactionDto getTransactionById(long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction", "id", id));
        return mapToDto(transaction);
    }

    @Override
    public TransactionDto updateTransactionById(long id, TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction", "id", id));
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());
        pointService.updatePoint(transaction.getPoint().getId(), transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return mapToDto(savedTransaction);
    }

    @Override
    public void deleteTransactionById(long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction", "id", id));
        pointService.deletePointById(transaction.getPoint().getId());
        transactionRepository.delete(transaction);
    }

    private TransactionDto mapToDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }
}
