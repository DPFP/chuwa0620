package com.chuwa.RewardsProgram.service.impl;

import com.chuwa.RewardsProgram.dao.TransactionRepository;
import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.entity.Transaction;
import com.chuwa.RewardsProgram.entity.User;
import com.chuwa.RewardsProgram.expection.BlogAPIException;
import com.chuwa.RewardsProgram.expection.ResourceNotFoundException;
import com.chuwa.RewardsProgram.payload.TransactionDto;
import com.chuwa.RewardsProgram.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TranscationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public TransactionDto createTransaction(long userId, TransactionDto transactionDto) {
//        return null;
        Transaction transaction = mapToEntity(transactionDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        transaction.setUser(user);
        Transaction savedTransaction = transactionRepository.save(transaction);

        return mapToDto(savedTransaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByUserId(long userId) {
//        return null;
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());

        return transactions.stream().map(transaction -> mapToDto(transaction)).collect(Collectors.toList());
    }

    @Override
    public TransactionDto getTransactionById(long userId, long transactionId) {
//        return null;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));

        if(!transaction.getUser().getId().equals(user.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to this user");
        }

        return mapToDto(transaction);
    }

    @Override
    public void deleteTransaction(long userId, long transactionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        if(!transaction.getUser().getId().equals(user.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Transaction does not belong to this user");
        }
        transactionRepository.delete(transaction);

    }


    private Transaction mapToEntity(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setTitle(transactionDto.getTitle());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(transactionDto.getDate());

        return transaction;
    }

    private TransactionDto mapToDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setTitle(transaction.getTitle());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDate(transaction.getDate());

        return transactionDto;
    }
}
