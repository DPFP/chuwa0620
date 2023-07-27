package com.example.demo.service;

import com.example.demo.payload.RewardDto;

public interface RewardService {

    RewardDto getRewardById(Long id,Integer month);
}
