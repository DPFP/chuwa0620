package com.chuwa.customer_rewarding_project.service;

import com.chuwa.customer_rewarding_project.payload.RewardingPointsDto;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsResponseDto;
import com.chuwa.customer_rewarding_project.payload.TransactionDto;

import java.util.List;

public interface RewardingPointsService {
    RewardingPointsDto createRewardingPoints(long customerId, TransactionDto transactionDto);
    RewardingPointsResponseDto getRewardingPointsInPastThreeMonths(long customerId);
    RewardingPointsResponseDto getRewardingPointsInCurrentMonths(long customerId);
    double getRewardingPointsByCustomerIdInTotal(long customerId);
    List<RewardingPointsDto> getAllRewardingPointsRecord();
    void deleteRewardingPoints(long id);
}
