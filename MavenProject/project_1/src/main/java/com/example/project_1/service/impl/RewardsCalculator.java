package com.example.project_1.service.impl;

import org.springframework.stereotype.Component;

@Component
public class RewardsCalculator {
    public double calculateRewardPoints(double amount) {
        double rewardPoints = 0;
        if (amount >= 100) {
            rewardPoints += 2 * (amount - 100) + 50;
        } else if (amount > 50) {
            rewardPoints += amount - 50;
        }
        return rewardPoints;
    }
}

