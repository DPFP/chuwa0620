package com.example.coding1reward.service;

import com.example.coding1reward.payload.RewardResponse;

public interface CustomerService {
    RewardResponse getTotalRewardByCustomerId(long id);
    RewardResponse getRewardByCustomerIdByMonthsLimit(long id, long monthsLimit, boolean zeroRecordShow);
}
