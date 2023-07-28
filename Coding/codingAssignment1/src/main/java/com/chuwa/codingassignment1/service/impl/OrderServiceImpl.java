package com.chuwa.codingassignment1.service.impl;

import com.chuwa.codingassignment1.entity.Order;
import com.chuwa.codingassignment1.payload.OrderDto;
import com.chuwa.codingassignment1.repository.OrderRepository;
import com.chuwa.codingassignment1.service.OrderService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger =
            LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public double getTotalPointsWithinCustomMonths(Long id, int months) {
        // 计算指定月数前的日期
        LocalDateTime startDate = LocalDateTime.now().minusMonths(months);
        logger.info("get total points within " + months + "months");
        // 调用Repository方法查询指定用户在指定月数内的分数总和

        return orderRepository.getTotalScoreWithinCustomMonths(id, startDate);
    }
}
