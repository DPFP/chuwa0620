package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto pto);
    List<PostDto> getAllPosts();
}
