package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto pto);

    List<PostDto> getAllPosts();

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    void deteleById(long id);

    PostDto updatePost(long id, PostDto pto);
}
