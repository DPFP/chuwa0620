package com.chuwa.rewardprogram.controller;

import com.chuwa.rewardprogram.payload.CustomerDto;
import com.chuwa.rewardprogram.payload.CustomerInfoDto;
import com.chuwa.rewardprogram.service.CustomerService;
import com.chuwa.rewardprogram.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto cto) {
        CustomerDto response = this.customerService.createCustomer(cto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDto> getCustomerInfo(@PathVariable(name="id") long id) {
        CustomerInfoDto response = new CustomerInfoDto();
        CustomerDto customerDto = this.customerService.getCustomerById(id);

        // calculate
        int totalPoints = this.transactionService.calculateCustomerTotalPoints(id);
        int pastMonthPoints = this.transactionService.pointsInPastNMonths(id,1);
        int pastTwoMonthPoints = this.transactionService.pointsInPastNMonths(id,2);
        int pastThreeMonthPoints = this.transactionService.pointsInPastNMonths(id,3);

        // set response
        response.setId(customerDto.getId());
        response.setUserName(customerDto.getUserName());
        response.setTotalPoints(totalPoints);
        response.setFirstMonth(pastMonthPoints);
        response.setSecondMonth(pastTwoMonthPoints-pastMonthPoints);
        response.setThirdMonth(pastThreeMonthPoints-pastTwoMonthPoints);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }




}
