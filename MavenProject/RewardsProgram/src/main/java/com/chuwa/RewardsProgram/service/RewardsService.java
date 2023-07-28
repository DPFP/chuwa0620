package com.chuwa.RewardsProgram.service;

import com.chuwa.RewardsProgram.entity.Transaction;
import com.chuwa.RewardsProgram.payload.RewardsDto;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

public interface RewardsService {

    double calculatePerRewards(double amount);
    double totalmonthlyRewards(List<Transaction> transactions);
    RewardsDto totalRewards(long userId);
    List<RewardsDto> getAllRewards();

    RewardsDto rangeRewards(long userId, LocalDate start, LocalDate end);

}
