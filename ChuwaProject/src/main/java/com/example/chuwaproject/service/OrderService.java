package com.example.chuwaproject.service;

import com.example.chuwaproject.bean.Order;
import com.example.chuwaproject.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private OrderDao orderDao;
    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public List<Order> findAllOrders(){return orderDao.findAll();}

    public List<Order> getOrdersByUserIdAndMonths(Long userId, int months) {
        // Calculate the starting date based on the current date and the number of months
        LocalDate startDate = LocalDate.now().minusMonths(months);
        // Fetch the orders for the specified userId and within the given number of months
        List<Order> orders = orderDao.findByUser_IdAndDateGreaterThanEqual(userId, startDate);
        return orders;
    }
}
