package com.example.project_1.service;

import com.example.project_1.dto.TransactionDTO;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    List<TransactionDTO> getTransactionsByCustomerId(Long customerId);

    Map<String, Double> calculateRewardPointsPerMonth(Long customerId);

    Double calculateRewardPointsTotalMonth(Long customerId);

    Double calculateRewardPointsPreviousMonthTotal(Long customerId, Long months);
}

