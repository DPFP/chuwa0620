package com.chuwa.learn.demo.Service.Impl;

import com.chuwa.learn.demo.Service.OrderService;
import com.chuwa.learn.demo.dao.CustomerRepository;
import com.chuwa.learn.demo.dao.OrderRepository;
import com.chuwa.learn.demo.entity.Customer;
import com.chuwa.learn.demo.entity.Order;
import com.chuwa.learn.demo.exception.OrderNumberExistedException;
import com.chuwa.learn.demo.exception.ResourceNotFoundException;
import com.chuwa.learn.demo.payload.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }



    public OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderCost(order.getOrderCost());
        dto.setOrderDate(order.getOrderDate());
        dto.setOrderNumber(order.getOrderNumber());
        dto.setCustomerId(order.getCustomer().getId());
        return dto;
    }
    public Order convertToEntity(OrderDTO dto) {
        Order order = new Order();
        //不需要id，id自动生成自增
        order.setOrderCost(dto.getOrderCost());
        order.setOrderNumber(dto.getOrderNumber());
        order.setOrderDate(LocalDateTime.now());

        return order;
    }
    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order", "id", id));
        return convertToDTO(order);
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("customer","id",orderDTO.getCustomerId()));

        Optional<Order> orderOptional = orderRepository.findByOrderNumber(orderDTO.getOrderNumber());
        if (orderOptional.isPresent()) {
            throw new OrderNumberExistedException(orderDTO.getOrderNumber());
        }

        Order order = convertToEntity(orderDTO);

        order.setCustomer(customer);

        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }
    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order", "id", id));


        String originOrderNumber = order.getOrderNumber();

        if (!originOrderNumber.equals(orderDTO.getOrderNumber())) {
            Optional<Order> orderOptional = orderRepository.findByOrderNumber(orderDTO.getOrderNumber());
            if (orderOptional.isPresent()) {
                throw new OrderNumberExistedException(orderDTO.getOrderNumber());
            }
            order.setOrderNumber(orderDTO.getOrderNumber());
        }

        order.setOrderCost(orderDTO.getOrderCost());

        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("customer","id",id));

        order.setCustomer(customer);


        Order updatedOrder = orderRepository.save(order);
        return convertToDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
