package com.chuwa.learning.reward_calculator.service;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class RewardService {

    private final Environment env;

    public RewardService(Environment env) {
        this.env = env;
    }

    public double calculateRewardPoints(double amount) {
        int firstCap = Integer.parseInt(Objects.requireNonNull(env.getProperty("SINGLE-POINT-CAP")));
        int secondCap = Integer.parseInt(Objects.requireNonNull(env.getProperty("DOUBLE-POINT-CAP")));
        int firstLevelReward = Integer.parseInt(Objects.requireNonNull(env.getProperty("REWARD-FOR-FIRST-CAP")));
        int secondLevelReward = Integer.parseInt(Objects.requireNonNull(env.getProperty("REWARD-FOR-SECOND-CAP")));
        if(amount < firstCap){
            return 0;
        }
        else if(amount <= secondCap){
            return firstLevelReward * (amount - firstCap);
        }
        else {
            return firstLevelReward * (secondCap - firstCap) + secondLevelReward * (amount - secondCap);
        }
    }
}
