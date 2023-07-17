package com.example.redbook.service.impl;

import com.example.redbook.dao.PostRepository;
import com.example.redbook.entity.Post;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.PostDto;
import com.example.redbook.service.PostService;
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
    public PostDto createPost(PostDto postDto) {
        //PostDTO -> Post(entity)
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());
        Post savedPost = this.postRepository.save(newPost);

        //Post(entity) -> PostDTO
        return PostToDto(savedPost);

    }

    private static PostDto PostToDto(Post savedPost){
        //Post(entity) -> PostDTO
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());

        return response;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> PostToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        return PostToDto(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id)));
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return PostToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        postRepository.deleteById(id);
    }
}