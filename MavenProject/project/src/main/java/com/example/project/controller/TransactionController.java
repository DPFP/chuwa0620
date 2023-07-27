package com.example.project.controller;

import com.example.project.payload.TransactionDto;
import com.example.project.service.TransactionService;
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
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable(name = "customerId") Long customerId, @RequestBody TransactionDto transactionDto){
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
    ResponseEntity<TransactionDto> updateTransaction(@RequestBody List<Long> productIdsToBeAddedOrDeleted,
                                                     @PathVariable(name = "customerId") Long customerId, @PathVariable(name = "transactionId") Long transactionId,
                                                     @RequestParam(name = "add", required = true) boolean add){
        if(add){
            return ResponseEntity.ok(transactionService.addProductsToTransactionByProductIds(productIdsToBeAddedOrDeleted, customerId, transactionId));
        }else{
            return ResponseEntity.ok(transactionService.deleteProductsInTransactionByProductIds(productIdsToBeAddedOrDeleted, customerId, transactionId));
        }
    }

    @DeleteMapping("/customers/{customerId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable(name = "customerId") Long customerId, @PathVariable(name = "transactionId") Long transactionId){
        transactionService.deleteTransactionById(customerId, transactionId);
        return new ResponseEntity<>("Transaction entity deleted successfully.", HttpStatus.OK);
    }
}
