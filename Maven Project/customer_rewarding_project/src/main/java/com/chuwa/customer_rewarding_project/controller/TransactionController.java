package com.chuwa.customer_rewarding_project.controller;

import com.chuwa.customer_rewarding_project.payload.TransactionCreatedResponseDto;
import com.chuwa.customer_rewarding_project.payload.TransactionDto;
import com.chuwa.customer_rewarding_project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping("customer/{customerId}/transaction")
    public ResponseEntity<TransactionCreatedResponseDto> createTransaction(@PathVariable(name = "customerId") long customerId,
                                                                           @RequestBody TransactionDto transactionDto){
        logger.info("User with id " + customerId + "is creating a transaction.");
        return new ResponseEntity<>(this.transactionService.createTransaction(customerId, transactionDto),
                HttpStatus.CREATED);
    }

    @GetMapping("customer/{customerId}/transaction")
    public  ResponseEntity<List<TransactionDto>> getTransactionByCustomerId(
            @PathVariable(name = "customerId") long id
    ){
        logger.info("Retrieving all transactions for user with id: " + id);
        return new ResponseEntity<>(this.transactionService.getTransactionsByCustomerId(id), HttpStatus.OK);
    }

    @GetMapping("transaction/{id}")
    public  ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") long id){
        logger.info("Retrieving transaction with id: " + id);
        return new ResponseEntity<>(this.transactionService.getTransactionsById(id), HttpStatus.OK);
    }
    @DeleteMapping("transaction/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){
        logger.info("Deleting transaction by id: " + id);
        this.transactionService.deleteTransactionById(id);
        return new ResponseEntity<>("Deleted transaction id: " + id, HttpStatus.OK);
    }
}
