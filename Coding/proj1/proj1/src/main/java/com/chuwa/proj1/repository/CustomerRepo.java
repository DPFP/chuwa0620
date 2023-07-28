package com.chuwa.proj1.repository;

import com.chuwa.proj1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Customer findByCustomerId(Long customerId);
}
