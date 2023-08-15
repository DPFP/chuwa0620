package com.example.chuwaproject.dao;

import com.example.chuwaproject.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
