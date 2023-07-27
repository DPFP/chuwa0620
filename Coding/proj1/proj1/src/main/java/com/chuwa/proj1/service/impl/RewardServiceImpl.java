package com.chuwa.proj1.service.impl;

import com.chuwa.proj1.constants.Constants;
import com.chuwa.proj1.model.Rewards;
import com.chuwa.proj1.model.Transaction;
import com.chuwa.proj1.payload.RewardDto;
import com.chuwa.proj1.repository.TransactionRepo;
import com.chuwa.proj1.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    TransactionRepo transactionRepo;
    @Override
    public RewardDto getRewardsByCustomerId(Long customerId) {
        Timestamp lastOneTime = getDate(Constants.daysInMonths);
        Timestamp lastTwoTime = getDate(2*Constants.daysInMonths);
        Timestamp lastThreeTime = getDate(3*Constants.daysInMonths);
        List<Transaction> lastOneMonthTransactions = transactionRepo.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastOneTime, Timestamp.from(Instant.now()));
        List<Transaction> lastTwoMonthTransactions = transactionRepo
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastTwoTime, lastOneTime);
        List<Transaction> lastThreeMonthTransactions = transactionRepo
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThreeTime,
                        lastTwoTime);

        Long lastMonthRewardPoints = getRewards(lastOneMonthTransactions);
        Long lastSecondMonthRewardPoints = getRewards(lastTwoMonthTransactions);
        Long lastThirdMonthRewardPoints = getRewards(lastThreeMonthTransactions);

        RewardDto customerRewards = new RewardDto();
        customerRewards.setCustomerId(customerId);
        customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
        customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return customerRewards;
    }

    private Timestamp getDate(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }

    private Long getRewards(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> calculateRewards(transaction)).mapToLong(r -> (Long)r).sum();
    }

    private Object calculateRewards(Transaction transaction) {
        double amount = transaction.getTransactionAmount();
        if (amount > Constants.firstRewardLimit && amount <= Constants.secondRewardLimit) {
            return Math.round(amount - Constants.firstRewardLimit);
        } else if (amount > Constants.secondRewardLimit) {
            return Math.round(amount - Constants.secondRewardLimit) * 2
                    + (Constants.secondRewardLimit - Constants.firstRewardLimit);
        } else
            return 0l;
        }
}
