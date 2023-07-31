package com.chuwa.RewardsProgram.service.impl;

import com.chuwa.RewardsProgram.dao.TransactionRepository;
import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.entity.*;
import com.chuwa.RewardsProgram.service.DataInitialize;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataInitializeImpl implements DataInitialize {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;



    @Override
    @PostConstruct
    public void addData() {
        User user1 = new User();
        user1.setName("Mike");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("John");
        userRepository.save(user2);

        Transaction transaction1 = new Transaction();
        transaction1.setUser(user1);
        transaction1.setAmount(276.0);
        transaction1.setTitle("tb");
        transaction1.setDate(LocalDate.of(2023, 7, 1));
        transactionRepository.save(transaction1);


        Transaction transaction2 = new Transaction();
        transaction2.setUser(user1);
        transaction2.setAmount(73.2);
        transaction2.setTitle("uber");
        transaction2.setDate(LocalDate.of(2023, 6, 1));
        transactionRepository.save(transaction2);

        Transaction transaction3 = new Transaction();
        transaction3.setUser(user1);
        transaction3.setAmount(125.0);
        transaction3.setTitle("amazon");
        transaction3.setDate(LocalDate.of(2023, 3, 1));
        transactionRepository.save(transaction3);
    }
}
