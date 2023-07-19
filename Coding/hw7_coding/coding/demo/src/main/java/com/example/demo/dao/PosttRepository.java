package com.example.demo.dao;

import com.example.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosttRepository  extends MongoRepository<Post, Long> {
    //Currently no code needed
}
