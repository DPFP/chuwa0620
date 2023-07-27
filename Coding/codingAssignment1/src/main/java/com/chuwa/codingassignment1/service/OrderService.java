package com.chuwa.codingassignment1.service;

import com.chuwa.codingassignment1.payload.OrderDto;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    double getTotalPointsWithinCustomMonths(Long id, int months);
}
