package com.example.project.dao;

import com.example.project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(Long customerId);
    @Query(value = "SELECT * FROM transactions t WHERE t.customer_id = :customer_id AND t.date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Transaction> findByIdWithinMonth(@Param("customer_id") Long customer_id,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);
}

