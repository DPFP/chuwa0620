package com.chuwa.learning.rewardcalculatorv2.Dao;

import com.chuwa.learning.rewardcalculatorv2.Entity.Order;
import com.chuwa.learning.rewardcalculatorv2.Entity.User;
import com.chuwa.learning.rewardcalculatorv2.Exception.UserNotFoundException;
import org.springframework.beans.PropertyValues;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DataStore {
    private final List<User> users = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public DataStore() {
        users.add(new User(1l,"qq","12345",null));
        users.add(new User(2l,"pp","11111",null));
        orders.add(new Order(1l, 1l, LocalDateTime.now(), 120.0));
        orders.add(new Order(2l, 1l,LocalDateTime.now(), 60.0));
        orders.add(new Order(3l, 2l,LocalDateTime.now(), 70.0));
    }

    public List<Order> getOrdersByUserId(Long userId) {

        return orders.stream().filter(order -> order.getUserId()==userId).collect(Collectors.toList());
    }

    public void addOrder(Order newOrder) {
        orders.add(newOrder);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void deleteUser(Long id) {
        int index = -1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new UserNotFoundException(String.valueOf(id));
        }
        else{
            users.remove(index);
        }
    }

    public List<User> getAllUsers() {
        return users;
    }

    // Methods to add, delete, and retrieve users and orders from the lists
    // ...
}

