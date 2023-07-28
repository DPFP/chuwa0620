package com.chuwa.customer_rewarding_project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardingPointsResponseDto {
    double amount;
    LocalDate startDate;
    LocalDate endDate;
}
