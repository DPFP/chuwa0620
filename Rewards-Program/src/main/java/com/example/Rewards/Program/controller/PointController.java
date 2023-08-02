package com.example.Rewards.Program.controller;

import com.example.Rewards.Program.payload.PointDto;
import com.example.Rewards.Program.service.PointService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1")
public class PointController {
    private PointService pointService;
    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/point/{id}")
    public ResponseEntity<PointDto> findPointById(@PathVariable(name = "id") long id){
        logger.info("Output all the point record");
        PointDto response = pointService.findPointById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/point")
    public ResponseEntity<Double> findTotalPoint(@PathVariable(name = "customerId") long customerId){
        logger.info("Output all the point record of customer: " + customerId);
        double response = pointService.findTotalPoint(customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/point/search")
    public ResponseEntity<Double> findAveragePoint(@PathVariable(name = "customerId") long customerId,
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "startDay") LocalDate startDay,
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "endDay") LocalDate endDay){
        logger.info("Output all the point record of customer: " + customerId + " from " + startDay + " to " + endDay);
        double response = pointService.findAveragePoint(customerId,startDay,endDay);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/point/{id}")
    public ResponseEntity<String> deletePointById(@PathVariable(name = "id") long id){
        logger.info("Deleted point record: " + id);
        pointService.deletePointById(id);
        return new ResponseEntity<>("Point record deleted successfully", HttpStatus.OK);
    }
}
