package com.example.hw40.dao;
import com.example.hw40.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CustomerDao extends MongoRepository<Customer,String>{

}
