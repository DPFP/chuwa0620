package com.chuwa.proj1.payload;

public class RewardDto {
    private long customerId;
    private long lastMonthRewardPoints;
    private long lastSecondMonthRewardPoints;
    private long lastThirdMonthRewardPoints;
    private long totalRewards;
    public RewardDto() {

    }

    public RewardDto(long customerId, long lastMonthRewardPoints, long lastSecondMonthRewardPoints, long lastThirdMonthRewardPoints, long totalRewards) {
        this.customerId = customerId;
        this.lastMonthRewardPoints = lastMonthRewardPoints;
        this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
        this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
        this.totalRewards = totalRewards;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getLastMonthRewardPoints() {
        return lastMonthRewardPoints;
    }

    public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
        this.lastMonthRewardPoints = lastMonthRewardPoints;
    }

    public long getLastSecondMonthRewardPoints() {
        return lastSecondMonthRewardPoints;
    }

    public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
        this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
    }

    public long getLastThirdMonthRewardPoints() {
        return lastThirdMonthRewardPoints;
    }

    public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
        this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
    }

    public long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }
}
