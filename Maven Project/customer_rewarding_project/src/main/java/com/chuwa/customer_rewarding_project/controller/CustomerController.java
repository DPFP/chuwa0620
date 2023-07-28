package com.chuwa.customer_rewarding_project.controller;

import com.chuwa.customer_rewarding_project.payload.CustomerDto;
import com.chuwa.customer_rewarding_project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        logger.info("User with email address: " + customerDto.getEmail() + " is creating an account.");
        CustomerDto response = this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        logger.info("Retrieving all customer infos.");
        List<CustomerDto> response = this.customerService.getAllCustomers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") long id){
        logger.info("Retrieving user info with id: " + id);
        return new ResponseEntity<>(this.customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerInfo(@RequestBody CustomerDto customerDto,
                                                          @PathVariable(name = "id") long id){
        logger.info("Updating info of user with id: " + id);
        return new ResponseEntity<>(this.customerService.updateCustomerInfo(customerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){
        logger.info("Deleting user with id: " + id);
        this.customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted customer id: " + id, HttpStatus.OK);
    }
}
