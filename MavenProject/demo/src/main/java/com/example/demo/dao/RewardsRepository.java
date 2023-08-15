package com.example.demo.dao;

import com.example.demo.model.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RewardsRepository extends JpaRepository<Rewards, Long> {
    List<Rewards> findAllByCustomer_IdAndCreationDateTimeAfter(long customerId, LocalDate DateTime);
    List<Rewards> findAllByCustomer_Id(long customerId);
}
