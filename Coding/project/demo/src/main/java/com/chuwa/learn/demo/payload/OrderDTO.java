package com.chuwa.learn.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String orderNumber;
    private Double orderCost;
    private LocalDateTime orderDate;
    private Long customerId;
}
