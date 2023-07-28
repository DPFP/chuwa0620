package com.example.Rewards.Program.dao;

import com.example.Rewards.Program.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findAllByCustomer_Id(long customerId);
    List<Point> findAllByCustomer_IdAndCreateDateTimeAfter(long customerId, LocalDateTime createDateTime);
}
