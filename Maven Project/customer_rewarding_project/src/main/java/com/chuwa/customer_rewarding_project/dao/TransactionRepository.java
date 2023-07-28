package com.chuwa.customer_rewarding_project.dao;

import com.chuwa.customer_rewarding_project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(long customerId);
}
