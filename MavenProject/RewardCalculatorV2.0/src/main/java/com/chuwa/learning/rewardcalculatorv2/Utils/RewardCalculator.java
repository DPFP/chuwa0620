package com.chuwa.learning.rewardcalculatorv2.Utils;

import java.util.Objects;

public class RewardCalculator {
    public static double calculateRewardPoints(double amount, int firstCap, int secondCap, int firstLevelReward, int secondLevelReward) {

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
