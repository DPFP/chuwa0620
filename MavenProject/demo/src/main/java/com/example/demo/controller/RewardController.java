package com.example.demo.controller;

import com.example.demo.payload.RewardDto;
import com.example.demo.service.RewardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rewards")
@Slf4j
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @GetMapping("/{id}/{months}")
    public ResponseEntity<RewardDto> getRewardByIdAndMonth(@PathVariable(name = "id")Long id, @PathVariable(name = "months") Integer month){
        try{
            log.info("get reward api with id : {}, months: {}\n",id,month);
            return new ResponseEntity<>(rewardService.getRewardById(id,month), HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(new RewardDto(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
