package com.chuwa.learn.demo.dao;

import com.chuwa.learn.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
