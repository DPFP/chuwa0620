package com.chuwa.proj1.service;

import com.chuwa.proj1.model.Rewards;
import com.chuwa.proj1.payload.RewardDto;

public interface RewardService {
    public RewardDto getRewardsByCustomerId(Long customerId);
}
