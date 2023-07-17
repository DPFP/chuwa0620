package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
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
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return postToDto(post);
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // PostDto ---> Post entity
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());

        Post savePost = this.postRepository.save(newPost);

        // Post entity ---> PostDto
        PostDto response = postToDto(savePost);

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

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        Post savePost = this.postRepository.save(post);

        PostDto response = postToDto(savePost);

        return response;
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
