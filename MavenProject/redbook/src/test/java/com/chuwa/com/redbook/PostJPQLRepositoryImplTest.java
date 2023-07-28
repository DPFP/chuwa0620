package com.chuwa.com.redbook;

import com.chuwa.com.redbook.dao.impl.PostJPQLRepositoryImpl;
import com.chuwa.com.redbook.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostJPQLRepositoryImplTest {
    @Autowired
    private PostJPQLRepositoryImpl repository;

    private Post post = new Post(null, "title test", "decription test", "content test",
            null, null);

    @Test
    void getAllPostWithJPQL() {
        Post savePost = repository.insertPost(post);
        System.out.println(savePost);
    }


}


