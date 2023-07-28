package com.chuwa.rewardprogram.controller;

import com.chuwa.rewardprogram.exception.InvalidDateFormatException;
import com.chuwa.rewardprogram.payload.TransactionDto;
import com.chuwa.rewardprogram.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/customers/{customerId}/transactions")
    public ResponseEntity<TransactionDto> createCustomer(@PathVariable(value = "customerId") long id,
                                                         @RequestBody TransactionDto dto) {

        if (!dto.getPurchaseTime().matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidDateFormatException("Invalid date format. The pattern should be yyyy-MM-dd");
        }
        TransactionDto response = this.transactionService.createTransaction(id, dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
