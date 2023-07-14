package com.chuwa.learn.mongoblog.service.impl;

import com.chuwa.learn.mongoblog.model.Post;
import com.chuwa.learn.mongoblog.payload.PostDto;
import com.chuwa.learn.mongoblog.repository.PostRepository;
import com.chuwa.learn.mongoblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto pto) {
        // pto -> entity
        Post newPost = new Post();
        newPost.setTitle(pto.getTitle());
        newPost.setContent(pto.getContent());
        newPost.setDescription(pto.getDescription());

        Post savedPost = this.postRepository.save(newPost);
        // entity -> pto
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setContent(savedPost.getContent());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());

        return response;
    }

}