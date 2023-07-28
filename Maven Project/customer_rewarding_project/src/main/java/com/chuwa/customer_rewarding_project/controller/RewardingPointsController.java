package com.chuwa.customer_rewarding_project.controller;

import com.chuwa.customer_rewarding_project.payload.RewardingPointsDto;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsResponseDto;
import com.chuwa.customer_rewarding_project.service.RewardingPointsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RewardingPointsController {
    private final RewardingPointsService rewardingPointsService;
    private static final Logger logger = LoggerFactory.getLogger(RewardingPointsController.class);

    @GetMapping("/customer/{id}/points/available")
    public ResponseEntity<RewardingPointsResponseDto> getAvailablePoints(@PathVariable(name = "id") long id){
        logger.info("Get available points of user with id: " + id);
        return new ResponseEntity<>(this.rewardingPointsService.
                getRewardingPointsInPastThreeMonths(id), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}/points/current-month")
    public ResponseEntity<RewardingPointsResponseDto> getCurrentMonthPoints(@PathVariable(name = "id") long id){
        logger.info("Get points from current month of user with id: " + id);
        return new ResponseEntity<>(this.rewardingPointsService
                .getRewardingPointsInCurrentMonths(id), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}/points")
    public ResponseEntity<Double> getAllPointsByCustomerId(@PathVariable(name = "id") long id){
        logger.info("Get all points of user with id: " + id);
        return new ResponseEntity<>(this.rewardingPointsService
                .getRewardingPointsByCustomerIdInTotal(id), HttpStatus.OK);
    }

    @GetMapping("/points")
    public ResponseEntity<List<RewardingPointsDto>> getAllPoints(){
        logger.info("Get all points records.");
        return new ResponseEntity<>(this.rewardingPointsService
                .getAllRewardingPointsRecord(), HttpStatus.OK);
    }

    @DeleteMapping("/points/{id}")
    public ResponseEntity<String> deleteRewardingPointsRecord(
            @PathVariable(name = "id") long id){
        logger.info("Get all point records of user with id: " + id);
        this.rewardingPointsService.deleteRewardingPoints(id);
        return new ResponseEntity<>("Deleted rewarding points record by id: " + id, HttpStatus.OK);
    }
}
