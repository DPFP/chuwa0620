package com.example.coding1reward.controller;

import com.example.coding1reward.payload.CustomerDto;
import com.example.coding1reward.payload.RewardResponse;
import com.example.coding1reward.service.CustomerService;
import com.example.coding1reward.util.AppConstants;
import com.example.coding1reward.util.EncryUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.example.coding1reward.util.PdfUtils.pdfByteGenerated;


@RestController
@Validated
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto response = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> response = this.customerService.getAllCustomers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.customerService.getCustomerById(id), HttpStatus.OK);
    }

    // encrypt the response
    @GetMapping("/{id}/encrypt")
    public ResponseEntity<String> getCustomerByIdEncty(@PathVariable(name = "id") long id) throws Exception {
        CustomerDto customerDto = customerService.getCustomerById(id);
        String encryptResponse = EncryUtils.AesEncrypt(customerDto.toString());
        return new ResponseEntity<>(encryptResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerInfo(@RequestBody CustomerDto customerDto,
                                                          @PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.customerService.updateCustomerInfo(customerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id) {
        this.customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted customer id: " + id, HttpStatus.OK);
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable(name="id") long id, HttpServletResponse response) throws IOException {

        RewardResponse rewardResponse = customerService.getRewardByCustomerIdByMonthsLimit(id, 3, true);
        byte[] pdfContents = pdfByteGenerated(rewardResponse.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "user.pdf");

        // set customized cookie 1
        String cookieName = "myCookie";
        String cookieValue = "myCookieValue";
        Duration maxAge = Duration.ofHours(24);
        String domain = "mydomain.com";
        String path = "/mypath";
        boolean isSecure = false;
        boolean isHttpOnly = true;
        String setCookie = String.format("%s=%s; Max-Age=%s; Domain=%s; Path=%s; %s; %s",
                cookieName,
                cookieValue,
                maxAge.getSeconds(),
                domain,
                path,
                isSecure ? "Secure" : "",
                isHttpOnly ? "HttpOnly" : "");


        // set customized cookie 2
        Cookie cookie = new Cookie("myCookie", "myCookieValue");
        cookie.setMaxAge(24 * 60 * 60); // set expire time to 24 hours
        // optionally, you can set the domain, path, is secure, etc.
        // add cookie to response
        response.addCookie(cookie);

        headers.add(HttpHeaders.SET_COOKIE, setCookie);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContents);
    }




}
