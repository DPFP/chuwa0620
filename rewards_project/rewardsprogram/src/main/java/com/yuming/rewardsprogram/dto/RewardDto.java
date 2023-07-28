package com.yuming.rewardsprogram.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RewardDto {
    private Long id;
    private Long customerId;
    private int points;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
