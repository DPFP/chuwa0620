package com.example.mongoblog.service;

import com.example.mongoblog.model.BlogPost;
import com.example.mongoblog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

}
