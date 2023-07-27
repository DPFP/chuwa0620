package com.yuming.rewardsprogram.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long id;
    private Long customerId;
    private double amount;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
