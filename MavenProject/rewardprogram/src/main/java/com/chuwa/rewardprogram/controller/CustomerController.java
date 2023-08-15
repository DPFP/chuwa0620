package com.chuwa.rewardprogram.controller;

import com.chuwa.rewardprogram.payload.CustomerDto;
import com.chuwa.rewardprogram.payload.CustomerInfoDto;
import com.chuwa.rewardprogram.service.CustomerService;
import com.chuwa.rewardprogram.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.chuwa.rewardprogram.util.EncryptHelper.encrypt;
import static com.chuwa.rewardprogram.util.EncryptHelper.generate128BitAESKey;
import static com.chuwa.rewardprogram.util.PdfHelper.generatePdfFromString;
import static com.chuwa.rewardprogram.util.RandomHelper.generateRandomToken;

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

    // fake login
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        String authToken = generateRandomToken();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Set-Cookie", "authToken=" + authToken + "; HttpOnly; Path=/");
        return new ResponseEntity<>("Login successful!", responseHeaders, HttpStatus.OK);
    }

    // added cookies
    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDto> getCustomerInfo(@PathVariable(name="id") long id,
                                                           @RequestHeader("Authorization") String token) {
        if (isValidAuthToken(token)) {
            CustomerInfoDto response = new CustomerInfoDto();
            setCustomerInfoDto(response, id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    // encrypt url
    @GetMapping("/{id}/encrypt")
    public ResponseEntity<String> getCustomerInfoWithEncryption(@PathVariable(name="id") long id) {
        CustomerInfoDto response = new CustomerInfoDto();
        setCustomerInfoDto(response, id);
        try {
            String encryptedResponse = encrypt(response.toString(), generate128BitAESKey());
            return new ResponseEntity<>(encryptedResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error encrypting data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pdf url
    @GetMapping("/{id}/downloadPdf")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable(name="id") long id) throws IOException {
        CustomerInfoDto response = new CustomerInfoDto();
        setCustomerInfoDto(response, id);
        byte[] pdfContents = generatePdfFromString(response.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "user.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContents);
    }

    private void setCustomerInfoDto(CustomerInfoDto response, long id) {
        CustomerDto customerDto = this.customerService.getCustomerById(id);

        // calculate
        int totalPoints = this.transactionService.calculateCustomerTotalPoints(id);
        int pastMonthPoints = this.transactionService.pointsInPastNMonths(id, 1);
        int pastTwoMonthPoints = this.transactionService.pointsInPastNMonths(id, 2);
        int pastThreeMonthPoints = this.transactionService.pointsInPastNMonths(id, 3);

        // set response
        response.setId(customerDto.getId());
        response.setUserName(customerDto.getUserName());
        response.setTotalPoints(totalPoints);
        response.setFirstMonth(pastMonthPoints);
        response.setSecondMonth(pastTwoMonthPoints - pastMonthPoints);
        response.setThirdMonth(pastThreeMonthPoints - pastTwoMonthPoints);
    }

    private boolean isValidAuthToken(String authToken) {
        return authToken != null && !authToken.isEmpty();
    }
}
