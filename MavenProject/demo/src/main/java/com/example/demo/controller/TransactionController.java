package com.example.demo.controller;

import com.example.demo.payload.TransactionCreatedResponseDto;
import com.example.demo.payload.TransactionDto;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("customer/{customerId}/transaction")
    public ResponseEntity<TransactionCreatedResponseDto> createTransaction(@PathVariable(name = "customerId") long customerId,
                                                                           @RequestBody TransactionDto transactionDto){
        log.info("User with id " + customerId + "is creating a transaction.");
        return new ResponseEntity<>(this.transactionService.createTransaction(customerId, transactionDto),
                HttpStatus.CREATED);
    }

    @GetMapping("customer/{customerId}/transaction")
    public  ResponseEntity<List<TransactionDto>> getTransactionByCustomerId(
            @PathVariable(name = "customerId") long id
    ){
        log.info("Retrieving all transactions for user with id: " + id);
        return new ResponseEntity<>(this.transactionService.getTransactionsByCustomerId(id), HttpStatus.OK);
    }

    @GetMapping("transaction/{id}")
    public  ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") long id){
        log.info("Retrieving transaction with id: " + id);
        return new ResponseEntity<>(this.transactionService.getTransactionsById(id), HttpStatus.OK);
    }
    @DeleteMapping("transaction/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){
        log.info("Deleting transaction by id: " + id);
        this.transactionService.deleteTransactionById(id);
        return new ResponseEntity<>("Deleted transaction id: " + id, HttpStatus.OK);
    }
}
