package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionCreatedResponseDto {
    private Long id;
    private Double amount;
    private Double rewardingPointsGained;
}
