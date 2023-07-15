package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.BlogPostRepository;
import com.chuwa.mongoblog.entity.BlogPost;
import com.chuwa.mongoblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;


    @Override
    public void PostBlog(BlogPost blogPost) {
        blogPost.setPublicationDate(new Date());

        blogPostRepository.save(blogPost);
    }
}
