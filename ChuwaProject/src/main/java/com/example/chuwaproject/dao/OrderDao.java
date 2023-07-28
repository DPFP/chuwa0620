package com.example.chuwaproject.dao;

import com.example.chuwaproject.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByUser_IdAndDateGreaterThanEqual(Long userId, LocalDate date);
}
