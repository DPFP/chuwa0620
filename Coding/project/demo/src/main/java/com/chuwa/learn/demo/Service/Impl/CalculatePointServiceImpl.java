package com.chuwa.learn.demo.Service.Impl;

import com.chuwa.learn.demo.Service.CalculatePointService;
import com.chuwa.learn.demo.dao.CustomerRepository;
import com.chuwa.learn.demo.entity.Customer;
import com.chuwa.learn.demo.entity.Order;
import com.chuwa.learn.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculatePointServiceImpl implements CalculatePointService {
    private final int onePointBar = 50;
    private final int twoPointBar = 100;
    private CustomerRepository customerRepository;
    @Autowired
    public CalculatePointServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Map<String, Double> calculatePointPerMonth(Long id) {
        Map<String, Double> perMonthCostMap = new HashMap<>();

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("customer","id", id));

        List<Order> orders = customer.getOrders();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        Map<String, List<Order>> ordersPerMonth = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getOrderDate().format(formatter)));

        for (var key : ordersPerMonth.keySet()) {
            String month = key;
            List<Order> ordersWithinMonth = ordersPerMonth.get(key);
            double totalCostWithinMonth = ordersWithinMonth.stream()
                    .mapToDouble(Order::getOrderCost)
                    .sum();
            perMonthCostMap.put(month, totalCostWithinMonth);
        }

        return perMonthCostMap;
    }

    @Override
    public Double calculatePointThreeMonth(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("customer","id", id));
        List<Order> orders = customer.getOrders();
        double threeMonthSum = orders.stream()
                .filter(order->order.getOrderDate().isAfter(LocalDateTime.now().minusMonths(3)))
                .mapToDouble(Order::getOrderCost)
                .sum();
        return threeMonthSum;
    }

    @Override
    public Double calculatePointTotal(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("customer","id", id));
        List<Order> orders = customer.getOrders();
        double sum = orders.stream()
                .mapToDouble(Order::getOrderCost)
                .map(order -> calculateRule(order))
                .sum();
        return sum;
    }

    double calculateRule(double cost) {
        int res = 0;
        if (cost < onePointBar)return res;
        else {
            if (cost <= twoPointBar)return cost - onePointBar;
            else {
                return twoPointBar - onePointBar + (cost - twoPointBar)*2;
            }
        }
    }
}
