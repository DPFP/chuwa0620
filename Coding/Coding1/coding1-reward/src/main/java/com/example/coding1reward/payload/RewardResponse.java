package com.example.coding1reward.payload;

import java.util.Map;

public class RewardResponse {

    private Long customerId;

    private Double rewardTotal;

    private Map<String, Double> monthToReward;

    public RewardResponse(Long customerId, Double rewardTotal, Map<String, Double> monthToReward) {
        this.customerId = customerId;
        this.rewardTotal = rewardTotal;
        this.monthToReward = monthToReward;
    }

    public RewardResponse() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getRewardTotal() {
        return rewardTotal;
    }

    public void setRewardTotal(Double rewardTotal) {
        this.rewardTotal = rewardTotal;
    }

    public Map<String, Double> getMonthToReward() {
        return monthToReward;
    }

    public void setMonthToReward(Map<String, Double> monthToReward) {
        this.monthToReward = monthToReward;
    }

}
