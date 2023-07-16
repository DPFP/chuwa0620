package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto pto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    void deteleById(long id);

    PostDto updatePost(long id, PostDto pto);
}
