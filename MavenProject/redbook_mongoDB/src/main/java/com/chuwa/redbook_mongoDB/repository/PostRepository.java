package com.chuwa.redbook_mongoDB.repository;

import com.chuwa.redbook_mongoDB.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
