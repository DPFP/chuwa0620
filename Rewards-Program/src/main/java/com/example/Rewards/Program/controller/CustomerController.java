package com.example.Rewards.Program.controller;

import com.example.Rewards.Program.payload.CustomerDto;
import com.example.Rewards.Program.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController{
    private CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        logger.info(customerDto.getFirstName() + "" + customerDto.getLastName() + "created an account with email: " + customerDto.getEmail());
        CustomerDto response = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomer(){
        logger.info("Output all the customer records");
        List<CustomerDto> response = customerService.findAllCustomer();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable(name = "id") long id){
        logger.info("Output customer: " + id);
        CustomerDto response = customerService.getCustomerById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable(name = "id") long id,@RequestBody CustomerDto customerDto){
        logger.info("Updated customer: " + id);
        CustomerDto response = customerService.updateCustomerById(id, customerDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id") long id){
        logger.info("Deleted customer: " + id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted Successfully", HttpStatus.OK);
    }

}
