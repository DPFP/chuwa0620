package com.example.demo.service;

import com.example.demo.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostDto updatePostById(PostDto postDto, long id);

    void deletePostById(long id);
}
