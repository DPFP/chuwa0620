package com.chuwa.codingassignment1.repository;

import com.chuwa.codingassignment1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT SUM(o.points) FROM Order o WHERE o.createDateTime >= :startDate AND o.customerId = :id")
    double getTotalScoreWithinCustomMonths(@Param("id") Long id, @Param("startDate") LocalDateTime startDate);
}
