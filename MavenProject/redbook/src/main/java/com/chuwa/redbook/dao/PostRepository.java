package com.chuwa.redbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chuwa.redbook.entity.Post;
public interface PostRepository extends JpaRepository<Post, Long> {
    // no code need

}
