package com.chuwa.rewardprogram.dao;

import com.chuwa.rewardprogram.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
