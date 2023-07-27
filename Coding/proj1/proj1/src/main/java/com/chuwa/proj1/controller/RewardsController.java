package com.chuwa.proj1.controller;

import com.chuwa.proj1.model.Customer;
import com.chuwa.proj1.model.Rewards;
import com.chuwa.proj1.payload.RewardDto;
import com.chuwa.proj1.repository.CustomerRepo;
import com.chuwa.proj1.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class RewardsController {

    @Autowired
    RewardService rewardsService;

    @Autowired
    CustomerRepo customerRepository;

    @GetMapping(value = "/{customerId}/rewards")
    public ResponseEntity<RewardDto> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null)
        {
            throw new RuntimeException("Invalid / Missing customer Id ");
        }
        RewardDto customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards, HttpStatus.OK);
    }

}