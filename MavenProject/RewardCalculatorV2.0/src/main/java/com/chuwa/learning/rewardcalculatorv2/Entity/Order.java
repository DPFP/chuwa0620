package com.chuwa.learning.rewardcalculatorv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Long id;
    private Long userId; // User ID associated with this order
    private LocalDateTime orderTime;
    private Double amount;
    // Getters and setters
}


