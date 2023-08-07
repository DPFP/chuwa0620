package com.example.project_1.controller;

import com.example.project_1.payload.TransactionDTO;
import com.example.project_1.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCustomerId(@PathVariable(name = "customerId") Long customerId) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByCustomerId(customerId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/reward-points/every-month/{customerId}")
    public ResponseEntity<Map<String, Double>> getRewardPointsEveryMonth(@PathVariable(name = "customerId") Long customerId) {
        Map<String, Double> rewardPointsPerMonth = transactionService.calculateRewardPointsPerMonth(customerId);
        return ResponseEntity.ok(rewardPointsPerMonth);
    }

    @GetMapping("/reward-points/total-month/{customerId}")
    public ResponseEntity<Double> getRewardPointsTotalMonth(@PathVariable(name = "customerId") Long customerId) {
        Double rewardPointsPerMonth = transactionService.calculateRewardPointsTotalMonth(customerId);
        return ResponseEntity.ok(rewardPointsPerMonth);
    }

    @GetMapping("/reward-points/previous-month/{customerId}/{months}")
    public ResponseEntity<Double> getRewardPointsTotalMonth(@PathVariable(name = "customerId") Long customerId, @PathVariable(name = "months") Long months) {
        logger.info("Received getRewardPointsTotalMonth request. customerId: " + customerId + ", months: " + months);
        Double rewardPointsPerMonth = transactionService.calculateRewardPointsPreviousMonthTotal(customerId, months);
        logger.info("Request completed successfully. customerId: " + customerId + ", months: " + months);
        return ResponseEntity.ok(rewardPointsPerMonth);
    }
}
