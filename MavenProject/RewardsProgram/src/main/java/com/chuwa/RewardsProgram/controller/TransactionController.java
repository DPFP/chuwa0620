package com.chuwa.RewardsProgram.controller;

import com.chuwa.RewardsProgram.payload.TransactionDto;
import com.chuwa.RewardsProgram.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    private TranscationService transcationService;

    @PostMapping("/users/{userId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(value = "userId") long userId,
                                                            @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transcationService.createTransaction(userId, transactionDto), HttpStatus.CREATED);
    }


    @GetMapping("/users/{userId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUserId(@PathVariable(value = "userId") long userId){
        return new ResponseEntity<>(transcationService.getTransactionsByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/transactions/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable(value = "userId") long userId,
                                                             @PathVariable(value = "transactionId") long transactionId){
        TransactionDto transactionDto = transcationService.getTransactionById(userId, transactionId);
        return new ResponseEntity<>(transactionDto, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable(value = "userId") long userId,
                                                    @PathVariable(value = "transactionId") long transactionId){
        transcationService.deleteTransaction(userId, transactionId);
        return new ResponseEntity<>("Transaction Deleted Successfully", HttpStatus.OK);
    }

}
