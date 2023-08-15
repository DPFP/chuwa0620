package com.example.coding1reward.controller;

import com.example.coding1reward.payload.RewardResponse;
import com.example.coding1reward.service.CustomerService;
import com.example.coding1reward.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/customers")
public class RewardController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}/reward/total")
    public ResponseEntity<RewardResponse> getTotalRewardById(@PathVariable(name = "id") long id){
        RewardResponse rewardResponse = customerService.getTotalRewardByCustomerId(id);
        return new ResponseEntity<>(rewardResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/reward/months")
    public ResponseEntity<RewardResponse> getRewardByCustomerIdAndMonthsLimit(
            @PathVariable(name = "id") long id,
            @RequestParam(name = "months-limit", required = false, defaultValue = AppConstants.DEFAULT_MONTHS_LIMIT) Integer monthsLimit,
            @RequestParam(name = "zero-record-show", required = false, defaultValue = AppConstants.DEFAULT_ZERO_RECORD_SHOW) boolean zeroRecordShow){

        RewardResponse rewardResponse = customerService.getRewardByCustomerIdByMonthsLimit(id, monthsLimit, zeroRecordShow);
        return new ResponseEntity<>(rewardResponse, HttpStatus.OK);
    }
}
