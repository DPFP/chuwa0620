package com.yuming.rewardsprogram.controller;

import com.yuming.rewardsprogram.dto.TransactionDto;
import com.yuming.rewardsprogram.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{customerId}")
    public TransactionDto createTransaction(@PathVariable Long customerId, @RequestBody TransactionDto transactionDto) {
        return transactionService.createTransaction(customerId, transactionDto);
    }

    @PutMapping("/{id}")
    public TransactionDto updateTransaction(@PathVariable Long id, @RequestBody TransactionDto transactionDto) {
        return transactionService.updateTransaction(id, transactionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>("Transaction deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}/{customerId}")
    public TransactionDto getTransactionById(@PathVariable Long id, @PathVariable Long customerId) {
        return transactionService.getTransactionById(id, customerId);
    }

    @GetMapping("/{customerId}")
    public List<TransactionDto> getAllTransactionsByCustomerId(@PathVariable Long customerId) {
        return transactionService.getAllTransactionsByCustomerId(customerId);
    }

    @GetMapping("/{customerId}/lastThreeMonths")
    public List<TransactionDto> getCustomerTransactionsInLastThreeMonths(@PathVariable Long customerId) {
        return transactionService.getCustomerTransactionsInLastThreeMonths(customerId);
    }

    @GetMapping("/{customerId}/timeRange")
    public List<TransactionDto> getAllTransactionsByCustomerIdAndTimeRange(@PathVariable Long customerId, @RequestParam LocalDateTime startTime, @RequestParam LocalDateTime endTime) {
        return transactionService.getAllTransactionsByCustomerIdAndTimeRange(customerId, startTime, endTime);
    }
}
