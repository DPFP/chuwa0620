package com.chuwa.rewardprogram.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chuwa.rewardprogram.entity.Transaction;

import java.util.List;

public interface TranscationRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(long id);

    List<Transaction> findByCustomerIdAndPurchaseTimeBetween(long customerId, String startDate, String endDate);

    // testing purpose
    List<Transaction> findByPurchaseTimeBetween(String startDate, String endDate);
}
