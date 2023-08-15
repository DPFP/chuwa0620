package com.chuwa.customer_rewarding_project.controller;

import com.chuwa.customer_rewarding_project.payload.CustomerDto;
import com.chuwa.customer_rewarding_project.service.CustomerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<List<CustomerDto>> getAllCustomers(HttpServletRequest request){
        logger.info("Retrieving all customer infos.");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // hard code to verify cookie
                if ("customer_id".equals(cookie.getName()) && Objects.equals(cookie.getValue(), "2")) {
                    List<CustomerDto> response = this.customerService.getAllCustomers();
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
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

    @PostMapping("/login")
    public ResponseEntity<String> customerLogin(@RequestBody CustomerDto customerDto,
                                                HttpServletResponse response){
        Long userId = customerDto.getId();
        Cookie cookie = new Cookie("customer_id", userId.toString());
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        String msg = "Log in successfully!";
        String encryptedMsg = Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
        return new ResponseEntity<>(encryptedMsg, HttpStatus.OK);
    }

    @GetMapping("/csv")
    public ResponseEntity<String> downloadCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"userInfo.csv\"");
        List<CustomerDto> customers = this.customerService.getAllCustomers();
        try (CSVWriter writer = new CSVWriter(response.getWriter())) {
            writer.writeNext(new String[]{"Firstname", "Lastname", "Email"});
            for (CustomerDto customer : customers) {
                writer.writeNext(new String[]{customer.getFirstname(), String.valueOf(customer.getLastname()), customer.getEmail()});
            }
        }
        return new ResponseEntity<>("Download Successfully!", HttpStatus.OK);
    }
}
