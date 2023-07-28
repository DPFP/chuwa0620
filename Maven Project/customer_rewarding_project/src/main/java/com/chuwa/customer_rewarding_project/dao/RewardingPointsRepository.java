package com.chuwa.customer_rewarding_project.dao;

import com.chuwa.customer_rewarding_project.entity.Customer;
import com.chuwa.customer_rewarding_project.entity.RewardingPoints;
import com.chuwa.customer_rewarding_project.payload.RewardingPointsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RewardingPointsRepository extends JpaRepository<RewardingPoints, Long> {
    List<RewardingPoints> findAllByCustomer_IdAndCreationDateTimeAfter(long customerId, LocalDate DateTime);
    List<RewardingPoints> findAllByCustomer_Id(long customerId);
}
