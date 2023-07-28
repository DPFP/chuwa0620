package com.chuwa.learn.demo.Service;

import com.chuwa.learn.demo.payload.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO orderdto, long id);
    void deleteOrder(Long id);

}
