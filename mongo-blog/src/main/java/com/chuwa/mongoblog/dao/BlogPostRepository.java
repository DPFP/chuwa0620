package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
}
