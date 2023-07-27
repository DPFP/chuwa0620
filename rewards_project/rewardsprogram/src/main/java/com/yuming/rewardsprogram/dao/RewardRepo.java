package com.yuming.rewardsprogram.dao;

import com.yuming.rewardsprogram.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RewardRepo extends JpaRepository<Reward, Long> {
    // Method signatures in RewardRepo interface
    List<Reward> findByCustomerIdAndCreateDateTimeBetween(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    List<Reward> findByCustomerId(Long customerId);
}

