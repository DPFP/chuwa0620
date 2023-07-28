package com.chuwa.codingassignment1.controller;

import com.chuwa.codingassignment1.payload.CustomerDto;
import com.chuwa.codingassignment1.service.CustomerService;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @ApiOperation("Create a new customer")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "Name of the customer", required = true, dataTypeClass = String.class, paramType = "query"),
//            @ApiImplicitParam(name = "email", value = "Email of the customer", required = true, dataTypeClass = String.class, paramType = "query")
//    })
    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto customerResponse = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }
}
