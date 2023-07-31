package com.chuwa.customer_rewarding_project.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardingPointsResponseDto {
    double amount;
    @JsonProperty("start date")
    LocalDate startDate;
    @JsonProperty("end date")
    LocalDate endDate;
}
