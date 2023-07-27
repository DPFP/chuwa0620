package com.chuwa.RewardsProgram.service.impl;

import com.chuwa.RewardsProgram.dao.TransactionRepository;
import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.entity.Transaction;
import com.chuwa.RewardsProgram.entity.User;
import com.chuwa.RewardsProgram.expection.MonthInvalidException;
import com.chuwa.RewardsProgram.expection.ResourceNotFoundException;
import com.chuwa.RewardsProgram.payload.RewardsDto;
import com.chuwa.RewardsProgram.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private RewardsService rewardsService;

    @Override
    public double calculatePerRewards(double amount) {
//        return 0;
        double rewardPoints = 0.0;

        if(amount > 50 && amount <=100){
            rewardPoints = amount - 50;
        }
        else if(amount > 100){
//            rewardPoints = amount - 50;
            rewardPoints = (amount - 100) * 2 + 50;
        }

        return rewardPoints;
    }

    @Override
    public double totalmonthlyRewards(List<Transaction> transactions) {
//        return 0;
        double totalRewardPoints = 0.0;
        for (Transaction transaction : transactions) {
            totalRewardPoints += calculatePerRewards(transaction.getAmount());
        }
        return totalRewardPoints;
    }


    @Override
    public RewardsDto totalRewards(long userId) {
//        return null;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());

//        Map<YearMonth, List<Transaction>> transactionsByMonth = transactions.stream()
//                .collect(Collectors.groupingBy(transaction -> YearMonth.from(transaction.getDate())));
//
//        List<RewardsDto.MonthlyDto> monthlyRewardsList = new ArrayList<>();
//        double totalRewards = 0.0;
//        for(Map.Entry<YearMonth, List<Transaction>> entry: transactionsByMonth.entrySet()){
//            double totalMonthlyRewards = totalmonthlyRewards(entry.getValue());
//            totalRewards += totalMonthlyRewards;
//            monthlyRewardsList.add(new RewardsDto.MonthlyDto(entry.getKey(),totalMonthlyRewards));
//        }
//        return new RewardsDto(user.getId(), monthlyRewardsList, totalRewards);

        return transactionsToRewards(user,transactions);
    }

//    @Override
//    public RewardsDto totalRewards(long userId) {
////        return null;
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());
//
//        Map<String, List<Transaction>> transactionsByMonth = transactions.stream()
//                .collect(Collectors.groupingBy(transaction -> transaction.getDate().getMonth().toString()));
//
//        List<RewardsDto.MonthlyDto> monthlyRewardsList = new ArrayList<>();
//        double totalRewards = 0.0;
//        for(Map.Entry<String, List<Transaction>> entry: transactionsByMonth.entrySet()){
//            double totalMonthlyRewards = totalmonthlyRewards(entry.getValue());
//            totalRewards += totalMonthlyRewards;
//            monthlyRewardsList.add(new RewardsDto.MonthlyDto(entry.getKey(),totalMonthlyRewards));
//        }
//        return new RewardsDto(user.getId(), monthlyRewardsList, totalRewards);
////        return null;
//    }

    @Override
    public List<RewardsDto> getAllRewards() {
//        return null;
        List<User> users = userRepository.findAll();
        List<RewardsDto> allRewards = users.stream().map(user -> totalRewards(user.getId())).collect(Collectors.toList());
        return allRewards;
    }

    @Override
    public RewardsDto rangeRewards(long userId, LocalDate start, LocalDate end) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        List<Transaction> transactions = transactionRepository.getTransactionsByRange(userId,start,end);
//        LocalDate startTime = start.atDay(1);
//        LocalDate endTime = end.atDay(end.lengthOfMonth());

        List<Transaction> transactions = transactionRepository.findTransactionsByUserAndDateBetween(user, start, end);
        return transactionsToRewards(user, transactions);
//        return null;
    }


//    public boolean validMonth(String start, String end){
//        try{
//            YearMonth startMonth = YearMonth.parse(start);
//            YearMonth endMonth = YearMonth.parse(end);
//            if(startMonth.isAfter(endMonth)){
//                throw new MonthInvalidException(HttpStatus.BAD_REQUEST, "The start month should not be later than the end month");
//            }
//
//        }catch (DateTimeException e){
//            throw new MonthInvalidException(HttpStatus.BAD_REQUEST,e.getMessage());
//        }
//
//    }

    public RewardsDto transactionsToRewards(User user, List<Transaction> transactions){
        Map<YearMonth, List<Transaction>> transactionsByMonth = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> YearMonth.from(transaction.getDate())));

        List<RewardsDto.MonthlyDto> monthlyRewardsList = new ArrayList<>();
        double totalRewards = 0.0;
        for(Map.Entry<YearMonth, List<Transaction>> entry: transactionsByMonth.entrySet()){
            double totalMonthlyRewards = totalmonthlyRewards(entry.getValue());
            totalRewards += totalMonthlyRewards;
            monthlyRewardsList.add(new RewardsDto.MonthlyDto(entry.getKey(),totalMonthlyRewards));
        }
        return new RewardsDto(user.getId(), monthlyRewardsList, totalRewards);
    }
}
