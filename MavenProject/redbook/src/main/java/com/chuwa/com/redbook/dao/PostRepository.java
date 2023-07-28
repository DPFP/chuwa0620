package com.chuwa.com.redbook.dao;

import com.chuwa.com.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
    @Query("Select p from Post p Where p.title Like %?1%")
    List<Post> findByTitleContains(String description);
}

