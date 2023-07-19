package com.example.demo.service.impl;

import com.example.demo.dao.PosttRepository;
import com.example.demo.model.Post;
import com.example.demo.payload.PostDto;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PosttRepository postRepository;

    public PostServiceImpl(PosttRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = getPost(postDto);
        Post savedPost = this.postRepository.save(newPost);
        PostDto response = getPostDto(savedPost);
        return response;
    }

    private static Post getPost(PostDto postDto) {
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContect(postDto.getContent());
        return newPost;
    }

    private static PostDto getPostDto(Post savedPost) {
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContect());
        return response;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> getPostDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long Id) {
        Post post = postRepository.findById(Id).orElseThrow(() -> new RuntimeException());
        return getPostDto(post);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(() ->  new RuntimeException());
        foundPost.setTitle(postDto.getTitle());
        foundPost.setDescription(postDto.getDescription());
        foundPost.setContect(postDto.getContent());

        Post updatedPost = postRepository.save(foundPost);
        return getPostDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(() ->  new RuntimeException());
        postRepository.delete(foundPost);
    }
}