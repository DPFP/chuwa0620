package com.chuwa.customer_rewarding_project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
    private Long id;
    private Double amount;
}
