package com.example.project_1.service.impl;

import com.example.project_1.payload.TransactionDTO;
import com.example.project_1.entity.Transaction;
import com.example.project_1.repo.TransactionRepository;
import com.example.project_1.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final RewardsCalculator rewardsCalculator;

    public TransactionServiceImpl(TransactionRepository transactionRepository, RewardsCalculator rewardsCalculator) {
        this.transactionRepository = transactionRepository;
        this.rewardsCalculator = rewardsCalculator;
    }

    @Override
    public List<TransactionDTO> getTransactionsByCustomerId(Long customerId) {
        List<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        // 转换Entity到DTO
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return transactionDTOs;
    }

    @Override
    public Map<String, Double> calculateRewardPointsPerMonth(Long customerId) {
        List<Transaction> customerTransactions = transactionRepository.findByCustomerId(customerId);
        Map<String, Double> rewardPointsPerMonth = new HashMap<>();

        // 计算每月的奖励积分
        for (Transaction transaction : customerTransactions) {
            String month = transaction.getDate().getMonth().toString();
            double rewardPoints = rewardsCalculator.calculateRewardPoints(transaction.getAmount());
            rewardPointsPerMonth.put(month, rewardPointsPerMonth.getOrDefault(month, 0.0) + rewardPoints);
        }

        return rewardPointsPerMonth;
    }

    @Override
    public Double calculateRewardPointsTotalMonth(Long customerId) {
        List<Transaction> customerTransactions = transactionRepository.findByCustomerId(customerId);

        return customerTransactions.stream().map(transaction -> rewardsCalculator.calculateRewardPoints(transaction.getAmount())).reduce(0.0, (a, b) -> a + b);

    }

    public static boolean isWithinNMonths(LocalDate date, Long n) {
        // 获取当前日期
        LocalDate now = LocalDate.now();

        // 计算目标日期与当前日期的差距
        Period period = Period.between(date, now);

        // 获取差距的月份
        int monthsDiff = period.getMonths();

        // 判断目标日期是否在n个月以内
        return ChronoUnit.DAYS.between(date, now) <= n * 30;
    }

    @Override
    public Double calculateRewardPointsPreviousMonthTotal(Long customerId, Long months) {
        List<Transaction> customerTransactions = transactionRepository.findByCustomerId(customerId);

        Map<String, Double> rewardPointsPerMonth = new HashMap<>();

        // 计算每月的奖励积分
        for (Transaction transaction : customerTransactions) {
            String month = transaction.getDate().getMonth().toString();
            double rewardPoints = rewardsCalculator.calculateRewardPoints(transaction.getAmount());
            rewardPointsPerMonth.put(month, rewardPointsPerMonth.getOrDefault(month, 0.0) + rewardPoints);
        }

        return customerTransactions.stream().filter(transaction -> isWithinNMonths(transaction.getDate(), months)).map(transaction -> rewardsCalculator.calculateRewardPoints(transaction.getAmount())).reduce(0.0, (a, b) -> a + b);
    }

    // 辅助方法：将Entity转换为DTO
    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setCustomerId(transaction.getCustomerId());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDate(transaction.getDate());
        return transactionDTO;
    }
}

