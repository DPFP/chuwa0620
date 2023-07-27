package com.yuming.rewardsprogram.dao;

import com.yuming.rewardsprogram.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(Long customerId);
    Optional<Transaction> findByIdAndCustomerId(Long id, Long customerId);
    List<Transaction> findByCustomerIdAndCreateDateTimeBetween(Long customerId, LocalDateTime startTime, LocalDateTime endTime);
}