package com.example.mongoblog.service.impl;

import com.example.mongoblog.model.BlogPost;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.repository.PostRepository;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        BlogPost newPost = new BlogPost();
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());
        BlogPost savedPost = postRepository.save(newPost);

        //Post(entity) -> PostDTO
        return PostToDto(savedPost);
    }

    private static PostDto PostToDto(BlogPost savedPost){
        //Post(entity) -> PostDTO
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());

        return response;
    }
}
