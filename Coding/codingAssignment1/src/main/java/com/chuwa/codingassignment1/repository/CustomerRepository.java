package com.chuwa.codingassignment1.repository;

import com.chuwa.codingassignment1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
