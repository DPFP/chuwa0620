package com.chuwa.RewardsProgram.dao;


import com.chuwa.RewardsProgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
