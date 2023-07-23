package com.chuwa.learn.transaction.repository;

import com.chuwa.learn.transaction.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
