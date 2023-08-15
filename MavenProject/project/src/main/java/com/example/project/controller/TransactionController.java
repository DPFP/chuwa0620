package com.example.project.controller;

import com.example.project.payload.CustomerDto;
import com.example.project.payload.ProductUpdateDto;
import com.example.project.payload.TransactionDto;
import com.example.project.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/customers/{customerId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(name = "customerId") Long customerId, @Valid @RequestBody TransactionDto transactionDto){
        TransactionDto response = this.transactionService.createTransaction(customerId, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{customerId}/transactions")
    public List<TransactionDto> getAllTransactionsByCustomerId(@PathVariable(name = "customerId") Long id){
        return transactionService.getAllTransactionsByCustomerId(id);
    }

    @GetMapping("/customers/{customerId}/transactions/{transactionId}")
    ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "customerId") Long customerId, @PathVariable(name = "transactionId") Long transactionId){
        return ResponseEntity.ok(transactionService.getTransactionById(customerId, transactionId));
    }

    @PutMapping("/customers/{customerId}/transactions/{transactionId}")
    ResponseEntity<TransactionDto> updateTransaction(@Valid @RequestBody ProductUpdateDto productUpdateDto,
                                                     @PathVariable(name = "customerId") Long customerId, @PathVariable(name = "transactionId") Long transactionId){
            return ResponseEntity.ok(transactionService.updateProductsInTransactionByProductIds(productUpdateDto, customerId, transactionId));
    }

    @DeleteMapping("/customers/{customerId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable(name = "customerId") Long customerId, @PathVariable(name = "transactionId") Long transactionId){
        transactionService.deleteTransactionById(customerId, transactionId);
        return new ResponseEntity<>("Transaction entity deleted successfully.", HttpStatus.OK);
    }
}
