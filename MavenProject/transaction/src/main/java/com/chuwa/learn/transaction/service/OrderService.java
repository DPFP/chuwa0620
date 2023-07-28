package com.chuwa.learn.transaction.service;

import com.chuwa.learn.transaction.dto.OrderRequest;
import com.chuwa.learn.transaction.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
