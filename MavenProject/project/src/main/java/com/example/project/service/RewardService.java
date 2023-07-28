package com.example.project.service;

import com.example.project.payload.RewardDto;

import java.time.LocalDate;

public interface RewardService {
    RewardDto getRewardsByCustomerIdAndPeriod(Long customerId, LocalDate endDate, int period);
}
