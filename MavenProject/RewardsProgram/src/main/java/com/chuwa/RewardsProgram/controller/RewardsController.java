package com.chuwa.RewardsProgram.controller;

import com.chuwa.RewardsProgram.expection.MonthInvalidException;
import com.chuwa.RewardsProgram.payload.RewardsDto;
import com.chuwa.RewardsProgram.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping("/{userId}")
    public ResponseEntity<RewardsDto> userRewards(@PathVariable(value = "userId") long userId){
        return new ResponseEntity<>(rewardsService.totalRewards(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RewardsDto>> allRewards(){
        return new ResponseEntity<>(rewardsService.getAllRewards(),HttpStatus.OK);
    }

    @GetMapping("/{userId}/threeMonths")
    public ResponseEntity<RewardsDto> userRewardsByRange(
            @PathVariable long userId){
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth startMonth,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth endMonth) {
        LocalDate endTime = LocalDate.now(); // Current date
        LocalDate startTime = endTime.minusMonths(3);
        return new ResponseEntity<>(rewardsService.rangeRewards(userId, startTime, endTime), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{startMonth}/{endMonth}")
    public ResponseEntity<RewardsDto> userRewardsByRange(
            @PathVariable long userId,
            @PathVariable String startMonth,
            @PathVariable String endMonth){
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth startMonth,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth endMonth) {

        validMonth(startMonth, endMonth);
        YearMonth start= YearMonth.parse(startMonth);
        YearMonth end = YearMonth.parse(endMonth);

        LocalDate startTime = start.atDay(1);
        LocalDate endTime = end.atDay(end.lengthOfMonth());
        return new ResponseEntity<>(rewardsService.rangeRewards(userId, startTime, endTime), HttpStatus.OK);
    }


    public void validMonth(String start, String end){
        try{
            YearMonth startMonth = YearMonth.parse(start);
            YearMonth endMonth = YearMonth.parse(end);
            if(startMonth.isAfter(endMonth)){
                throw new MonthInvalidException(HttpStatus.BAD_REQUEST, "The start month should not be later than the end month");
            }

        }catch (DateTimeException e){
            throw new MonthInvalidException(HttpStatus.BAD_REQUEST, "Invalid Input Month Format");
        }

    }

}
