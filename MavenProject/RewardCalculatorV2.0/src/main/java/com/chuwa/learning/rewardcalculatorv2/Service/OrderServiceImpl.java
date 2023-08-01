package com.chuwa.learning.rewardcalculatorv2.Service;

import com.chuwa.learning.rewardcalculatorv2.Dao.DataStore;
import com.chuwa.learning.rewardcalculatorv2.Dto.OrderDTO;
import com.chuwa.learning.rewardcalculatorv2.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private DataStore dataStore;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order newOrder = new Order();
        newOrder.setUserId(orderDTO.getUserId());
        newOrder.setOrderTime(LocalDateTime.now());
        newOrder.setAmount(orderDTO.getAmount());
        Long orderId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        newOrder.setId(orderId);

        dataStore.addOrder(newOrder);

        return mapOrderToOrderDTO(newOrder);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = dataStore.getAllOrders();
        return orders.stream().map(this::mapOrderToOrderDTO).collect(Collectors.toList());
    }

    // Other service methods related to orders

    private OrderDTO mapOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUserId());
        orderDTO.setOrderTime(order.getOrderTime());
        orderDTO.setAmount(order.getAmount());
        return orderDTO;
    }
}

