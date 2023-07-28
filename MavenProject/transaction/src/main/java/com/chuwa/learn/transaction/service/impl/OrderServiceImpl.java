package com.chuwa.learn.transaction.service.impl;

import com.chuwa.learn.transaction.dto.OrderRequest;
import com.chuwa.learn.transaction.dto.OrderResponse;
import com.chuwa.learn.transaction.entity.Order;
import com.chuwa.learn.transaction.entity.Payment;
import com.chuwa.learn.transaction.exception.PaymentException;
import com.chuwa.learn.transaction.repository.OrderRepository;
import com.chuwa.learn.transaction.repository.PaymentRepository;
import com.chuwa.learn.transaction.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository){
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
