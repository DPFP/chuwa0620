package com.chuwa.com.redbook.dao;

import com.chuwa.com.redbook.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {
    Post insertPost(Post post);
}
