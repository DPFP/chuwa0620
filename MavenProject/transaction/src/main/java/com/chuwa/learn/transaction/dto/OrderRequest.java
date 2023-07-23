package com.chuwa.learn.transaction.dto;

import com.chuwa.learn.transaction.entity.Order;
import com.chuwa.learn.transaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
