package com.chuwa.RewardsProgram.dao;

import com.chuwa.RewardsProgram.entity.Transaction;
import com.chuwa.RewardsProgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(long userId);
    List<Transaction> findTransactionsByUserAndDateBetween(User user, LocalDate start, LocalDate end);

//    @Query("SELECT t FROM Transaction t " +
//            "WHERE t.user.id = :userId " +
//            "AND FUNCTION('DATE_FORMAT', t.date, '%Y-%m') BETWEEN :start AND :end")
//    List<Transaction> getTransactionsByRange(
//            @Param("userId") Long userId,
//            @Param("start") String start,
//            @Param("end") String end);
}
