package com.yuming.rewardsprogram.service;

import com.yuming.rewardsprogram.dto.RewardDto;

import java.time.LocalDateTime;
import java.util.List;

public interface RewardService {
    int calculateRewardPointsForTransaction(double amount);
    RewardDto getRewardByCustomerIdAndTimeRange(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    RewardDto getRewardsForPastThreeMonths(Long customerId);
    List<RewardDto> getAllRewardsByCustomerId(Long customerId);

}
