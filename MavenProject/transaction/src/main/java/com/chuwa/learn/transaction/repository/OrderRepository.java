package com.chuwa.learn.transaction.repository;

import com.chuwa.learn.transaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
