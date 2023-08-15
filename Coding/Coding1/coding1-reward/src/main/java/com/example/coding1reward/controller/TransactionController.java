package com.example.coding1reward.controller;

import com.example.coding1reward.payload.TransactionDto;
import com.example.coding1reward.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("customer/{customerId}/transaction")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(name = "customerId") long customerId,
                                                                           @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(this.transactionService.createTransaction(customerId, transactionDto),
                HttpStatus.CREATED);
    }

    @GetMapping("customer/{customerId}/transaction")
    public  ResponseEntity<List<TransactionDto>> getTransactionByCustomerId(
            @PathVariable(name = "customerId") long id
    ){
        return new ResponseEntity<>(this.transactionService.getTransactionsByCustomerId(id), HttpStatus.OK);
    }

    @GetMapping("transaction/{id}")
    public  ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.transactionService.getTransactionsById(id), HttpStatus.OK);
    }

    @DeleteMapping("transaction/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){
        this.transactionService.deleteTransactionById(id);
        return new ResponseEntity<>("Deleted transaction id: " + id, HttpStatus.OK);
    }
}
