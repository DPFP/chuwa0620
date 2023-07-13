package com.example.hw40.controller;

import com.example.hw40.dao.CustomerDao;
import com.example.hw40.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    @GetMapping("/customer")
    public List<Customer> getCustomer(){
        System.out.println("123");
        return customerDao.findAll();
    }

    @PostMapping("/customer")
    public void postCustomer(@RequestBody Customer customer){
        System.out.println(123);
        Customer save = customerDao.save(customer);
        System.out.println(save);
    }
}
