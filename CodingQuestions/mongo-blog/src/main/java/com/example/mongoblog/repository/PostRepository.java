package com.example.mongoblog.repository;

import com.example.mongoblog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<BlogPost, Long> {
}
