package com.chuwa.customer_rewarding_project.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionCreatedResponseDto {
    private Long id;
    private Double amount;
    @JsonProperty("rewarding points gained")
    private Double rewardingPointsGained;
}
