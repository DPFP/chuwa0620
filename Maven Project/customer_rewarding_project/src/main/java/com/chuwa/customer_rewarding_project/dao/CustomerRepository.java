package com.chuwa.customer_rewarding_project.dao;

import com.chuwa.customer_rewarding_project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
