package chuwa.learning.demo.repository;

import chuwa.learning.demo.Entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
