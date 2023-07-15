package com.chuwa.mongoblog.repository;

import com.chuwa.mongoblog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
