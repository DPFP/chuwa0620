package com.yuming.rewardsprogram.service.impl;

import com.yuming.rewardsprogram.dao.CustomerRepo;
import com.yuming.rewardsprogram.dao.RewardRepo;
import com.yuming.rewardsprogram.dao.TransactionRepo;
import com.yuming.rewardsprogram.dto.RewardDto;
import com.yuming.rewardsprogram.entity.Transaction;
import com.yuming.rewardsprogram.exception.ResourceNotFoundException;
import com.yuming.rewardsprogram.service.RewardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    private final RewardRepo rewardRepo;
    private final CustomerRepo customerRepo;
    private final TransactionRepo transactionRepo;
    private final ModelMapper modelMapper;

    public RewardServiceImpl(RewardRepo rewardRepo, CustomerRepo customerRepo, TransactionRepo transactionRepo, ModelMapper modelMapper) {
        this.rewardRepo = rewardRepo;
        this.customerRepo = customerRepo;
        this.transactionRepo = transactionRepo;
        this.modelMapper = modelMapper;
    }


    // Implement the logic to calculate reward points for a transaction based on the given amount
    @Override
    public int calculateRewardPointsForTransaction(double amount) {
        if (amount <= 50) {
            return 0; // No reward points for transactions under $50
        } else if (amount <= 100) {
            return (int) (amount - 50); // 1 point for every dollar spent over $50
        } else {
            return (int) ((amount - 100) * 2 + 50); // 2 points for every dollar spent over $100 + 50 points for dollars spent between $51 and $100
        }
    }

    @Override
    public RewardDto getRewardByCustomerIdAndTimeRange(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        // Get the transactions of the customer for the given date range
        List<Transaction> customerTransactions = transactionRepo.findByCustomerIdAndCreateDateTimeBetween(customerId, startDateTime, endDateTime);

        if(customerTransactions.isEmpty()){
            throw new ResourceNotFoundException("Transactions", "CustomerId", customerId);
        }

        // Calculate the total reward points
        int totalRewardPoints = customerTransactions.stream()
                                                    .mapToInt(transaction -> calculateRewardPointsForTransaction(transaction.getAmount()))
                                                    .sum();

        // Create a new RewardDto object to store the total reward points for the customer
        RewardDto rewardDto = new RewardDto();
        rewardDto.setCustomerId(customerId);
        rewardDto.setPoints(totalRewardPoints);

        return rewardDto;
    }

    @Override
    public RewardDto getRewardsForPastThreeMonths(Long customerId) {
        LocalDateTime endDateTime = LocalDateTime.now();
        LocalDateTime startDateTime = endDateTime.minusMonths(3);

        return getRewardByCustomerIdAndTimeRange(customerId, startDateTime, endDateTime);
    }

    @Override
    public List<RewardDto> getAllRewardsByCustomerId(Long customerId) {
        List<Transaction> transactions = transactionRepo.findByCustomerId(customerId);
        return transactions.stream()
                           .map(transaction -> {
                               RewardDto rewardDto = new RewardDto();
                               rewardDto.setCustomerId(customerId);
                               rewardDto.setPoints(calculateRewardPointsForTransaction(transaction.getAmount()));
                               return rewardDto;
                           })
                           .collect(Collectors.toList());
    }
}
