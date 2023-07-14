package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.repository.PostRepository;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto pto) {
        Post newPost = new Post();
        newPost.setTitle(pto.getTitle());
        newPost.setContent(pto.getContent());
        newPost.setDescription(pto.getDescription());

        Post savedPost = this.postRepository.save(newPost);

        PostDto response = postToDto(savedPost);

        return response;
    }
    private static PostDto postToDto(Post savePost) {
        PostDto response = new PostDto();
        response.setId(savePost.getId());
        response.setTitle(savePost.getTitle());
        response.setDescription(savePost.getDescription());
        response.setContent(savePost.getContent());
        return response;
    }

    @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> postToDto(post)).collect(Collectors.toList());
    }
}
