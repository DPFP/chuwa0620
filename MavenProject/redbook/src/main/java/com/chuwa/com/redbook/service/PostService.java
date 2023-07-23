package com.chuwa.com.redbook.service;

import com.chuwa.com.redbook.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostByTitle(String title);

    List<PostDto> getPostsByTitleContains(String title);
}
