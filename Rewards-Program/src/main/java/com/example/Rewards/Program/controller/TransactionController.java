package com.example.Rewards.Program.controller;

import com.example.Rewards.Program.payload.TransactionDto;
import com.example.Rewards.Program.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/customer/{customerId}/transaction")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(name = "customerId") long customerId, @RequestBody TransactionDto transactionDto) {
        logger.info("Created transaction for customer: " + customerId);
        TransactionDto postResponse = transactionService.createTransaction(customerId,transactionDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customerId}/transaction")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        logger.info("Output all transaction");
        List<TransactionDto> transactionDtos = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactionDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping("transaction/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") long id){
        logger.info("Output transaction: " + id);
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
    }

    @PutMapping("transaction/{id}")
    public ResponseEntity<TransactionDto> updateTransactionById(@PathVariable(name = "id") long id, @RequestBody TransactionDto transactionDto){
        logger.info("Updated transaction: " + id);
        return new ResponseEntity<>(transactionService.updateTransactionById(id,transactionDto), HttpStatus.OK);
    }

    @DeleteMapping("transaction/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable(name = "id") long id){
        logger.info("Deleted transaction: " + id);
        transactionService.deleteTransactionById(id);
        return new ResponseEntity<>("Transaction delete successfully", HttpStatus.OK);
    }
}
