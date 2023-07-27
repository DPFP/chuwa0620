package com.yuming.rewardsprogram.controller;

import com.yuming.rewardsprogram.dto.RewardDto;
import com.yuming.rewardsprogram.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/{customerId}/rewards")
public class RewardController {
    private final RewardService rewardService;
    private static final Logger logger = LoggerFactory.getLogger(RewardController.class);

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public ResponseEntity<List<RewardDto>> getAllRewardsByCustomerId(@PathVariable Long customerId) {
        logger.info("Fetching all rewards for customer: {}", customerId);
        List<RewardDto> rewardDtos = rewardService.getAllRewardsByCustomerId(customerId);
        return ResponseEntity.ok(rewardDtos);
    }

    @GetMapping("/pastThreeMonths")
    public ResponseEntity<RewardDto> getRewardsForPastThreeMonths(@PathVariable Long customerId) {
        logger.info("Fetching rewards for the past three months for customer: {}", customerId);
        RewardDto rewardDto = rewardService.getRewardsForPastThreeMonths(customerId);
        return ResponseEntity.ok(rewardDto);
    }
}
