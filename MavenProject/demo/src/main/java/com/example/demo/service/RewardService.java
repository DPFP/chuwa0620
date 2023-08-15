package com.example.demo.service;

import com.example.demo.payload.RewardDto;
import com.example.demo.payload.RewardsDto;
import com.example.demo.payload.RewardsResponseDto;
import com.example.demo.payload.TransactionDto;

import java.util.List;

public interface RewardService {

    RewardDto getRewardById(Long id,Integer month);
    RewardDto createRewardingPoints(long customerId, TransactionDto transactionDto);
    RewardsResponseDto getRewardingPointsInPastThreeMonths(long customerId);
    RewardsResponseDto getRewardingPointsInCurrentMonths(long customerId);
    double getRewardingPointsByCustomerIdInTotal(long customerId);
    List<RewardDto> getAllRewardingPointsRecord();
    void deleteRewardingPoints(long id);
}
