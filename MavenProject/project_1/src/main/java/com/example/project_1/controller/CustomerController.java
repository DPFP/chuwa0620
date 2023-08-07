package com.example.project_1.controller;

import com.example.project_1.payload.CustomerDTO;
import com.example.project_1.service.CustomerService;
import com.example.project_1.service.impl.SecretKeyEncryption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDto) {
        System.out.println("a" + customerDto.getUsername());
        logger.info(customerDto.getFirstName() + "" + customerDto.getLastName() + "created an account with email: " + customerDto.getEmail());
        CustomerDTO response = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomer() {
        logger.info("Output all the customer records");
        List<CustomerDTO> response = customerService.findAllCustomer();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable(name = "id") long id) {
        logger.info("Output customer: " + id);
        CustomerDTO response = customerService.getCustomerById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomerById(@PathVariable(name = "id") long id, @RequestBody CustomerDTO customerDto) {
        logger.info("Updated customer: " + id);
        CustomerDTO response = customerService.updateCustomerById(id, customerDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id") long id) {
        logger.info("Deleted customer: " + id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted Successfully", HttpStatus.OK);
    }


    @GetMapping("/{id}/encrypt")
    public ResponseEntity<String> getCustomerUsernameWithEncryption(@PathVariable(name = "id") long id) {
        CustomerDTO customerDto = this.customerService.getCustomerById(id);

        String info = customerDto.getUsername();

        CustomerDTO response = new CustomerDTO();
        try {
            String encryptedResponse = SecretKeyEncryption.encrypt(info, SecretKeyEncryption.generateSecretKey());
            return new ResponseEntity<>(encryptedResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error encrypting data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}