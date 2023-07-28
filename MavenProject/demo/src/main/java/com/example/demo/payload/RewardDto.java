package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDto {
    private long userId;

    private double amount;

    private double rewards;

    private Date afterDate;

}
