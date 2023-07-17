package com.chuwa.learn.mongoblog.service;

import com.chuwa.learn.mongoblog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto pto);
}
