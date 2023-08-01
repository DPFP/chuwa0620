package com.chuwa.learning.rewardcalculatorv2.Service;

import com.chuwa.learning.rewardcalculatorv2.Dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    // Other service methods related to orders
}

