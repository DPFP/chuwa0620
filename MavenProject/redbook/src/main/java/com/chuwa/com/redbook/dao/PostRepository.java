package com.chuwa.com.redbook.dao;

import com.chuwa.com.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

