package com.yuming.rewardsprogram.dao;

import com.yuming.rewardsprogram.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
