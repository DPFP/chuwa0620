package com.yuming.rewardsprogram.controller;

import com.yuming.rewardsprogram.dto.CustomerDto;
import com.yuming.rewardsprogram.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto createdCustomerDto = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customerDtos = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        CustomerDto updatedCustomerDto = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updatedCustomerDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted successfully.", HttpStatus.OK);
    }

}
