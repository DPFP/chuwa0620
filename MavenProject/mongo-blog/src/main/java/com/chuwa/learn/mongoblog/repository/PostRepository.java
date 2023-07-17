package com.chuwa.learn.mongoblog.repository;

import com.chuwa.learn.mongoblog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
