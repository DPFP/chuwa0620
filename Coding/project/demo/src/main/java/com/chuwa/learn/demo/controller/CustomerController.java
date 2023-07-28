package com.chuwa.learn.demo.controller;

import com.chuwa.learn.demo.Service.CustomerService;
import com.chuwa.learn.demo.entity.Customer;
import com.chuwa.learn.demo.payload.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        if (customerDTO != null)return ResponseEntity.ok(customerDTO);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomerDTO = customerService.saveCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(customerDTO, id));
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return "id : " + id +" has been deleted";
    }
}
