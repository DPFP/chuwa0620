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
    public PostDto createPost(PostDto pto) {
        // pto -> entity
        Post newPost = DtoToPost(pto);

        Post savedPost = this.postRepository.save(newPost);
        // entity -> pto
        return postToDto(savedPost);
    }

    private static Post DtoToPost(PostDto pto) {
        Post newPost = new Post();
        newPost.setTitle(pto.getTitle());
        newPost.setContent(pto.getContent());
        newPost.setDescription(pto.getDescription());
        return newPost;
    }

    private static PostDto postToDto(Post savedPost) {
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setContent(savedPost.getContent());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        return response;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post-> postToDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return postToDto(post);
    }

    @Override
    public void deteleById(long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post", "id", id);
        }
        postRepository.deleteById(id);
    }

    @Override
    public PostDto updatePost(long id, PostDto pto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(pto.getTitle());
        post.setDescription(pto.getDescription());
        post.setContent(pto.getContent());
        Post updatedPost = postRepository.save(post);
        return postToDto(updatedPost);
    }
}
