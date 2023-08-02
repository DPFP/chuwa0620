package com.example.chuwaproject.utils;

import com.example.chuwaproject.bean.Order;
import com.example.chuwaproject.bean.User;
import com.example.chuwaproject.dto.OrderDTO;
import com.example.chuwaproject.dto.UserDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AllUtils {
    private final static ModelMapper modelMapper = new ModelMapper();
    public static int calculatePoints(int money) {
        int points = 0;
        if (money > 100) {
            int over100Points = (money - 100) * 2;
            points += over100Points;
        }

        if (money > 50) {
            int over50Points = Math.min(money - 50, 50);
            points += over50Points;
        }
        return points;
    }

    public static User mapToUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public static List<User> mapToUser(List<UserDTO> userDTOS){
        return userDTOS.stream()
                .map(AllUtils::mapToUser)
                .collect(Collectors.toList());
    }

    public static UserDTO mapToUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }

    public static List<UserDTO> mapToUserDTO(List<User> users){
        return users.stream()
                .map(AllUtils::mapToUserDTO)
                .collect(Collectors.toList());
    }

    public static OrderDTO mapToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public static List<OrderDTO> mapToOrderDTO(List<Order> orders){
        return orders.stream()
                .map(AllUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public static Order mapToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }
    public static List<Order> mapToOrder(List<OrderDTO> orderDTOS){
        return orderDTOS.stream()
                .map(AllUtils::mapToOrder)
                .collect(Collectors.toList());
    }
}
