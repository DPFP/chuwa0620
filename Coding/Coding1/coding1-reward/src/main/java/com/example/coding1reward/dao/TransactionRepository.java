package com.example.coding1reward.dao;

import com.example.coding1reward.entity.Customer;
import com.example.coding1reward.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionByCustomer(Customer customer);
    List<Transaction> findTransactionByCustomerAndCreateDateTimeBetween(Customer customer, LocalDateTime start, LocalDateTime end);
    Optional<Transaction> findFirstTransactionByCustomerOrderByCreateDateTimeAsc(Customer customer);
}
