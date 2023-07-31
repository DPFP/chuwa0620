package com.example.demo.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardsDto {
    private Long id;
    @JsonProperty("customer_rewards_amount")
    private Double amount;
}
