package com.example.project.controller;

import com.example.project.payload.RewardDto;
import com.example.project.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class RewardController {
    private RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/customers/{customerId}/rewards")
    ResponseEntity<RewardDto> getRewardByCustomerId(@PathVariable(name = "customerId") Long customerId,
                                                @RequestParam(name = "endDate", required = true) LocalDate endDate,
                                                @RequestParam(name = "period", required = true) int period){
        return ResponseEntity.ok(rewardService.getRewardsByCustomerIdAndPeriod(customerId, endDate, period));
    }
}
