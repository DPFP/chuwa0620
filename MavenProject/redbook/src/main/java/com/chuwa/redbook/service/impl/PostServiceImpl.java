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
    public PostDto createPost(PostDto postDto) {
        //PostDTO --> Post (entity)
        Post newPost = new Post();

        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());

        Post savedPost = this.postRepository.save(newPost);
        //Post (entity) --> PostDto
        PostDto response = postToDTO(savedPost);

        return response;
    }

    private static PostDto postToDTO(Post savedPost) {
        PostDto response = new PostDto();

        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());

        return response;
    }

    private Post DtoToPost(PostDto postDto){
        Post newPost = new Post();

        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());

        return newPost;
    }

    @Override
    public List<PostDto> getAllPost() {
        //#1 Get all data from DB via Repository/DAO
        List<Post> posts = postRepository.findAll();

        //#2 Tranfer all entities to DTOs
        return posts.stream().map(PostServiceImpl::postToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourceName:Post", "FieldName:id", id));

        return postToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //find the post by id
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //similar create post
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //save the updated Post
        Post updatedPost = postRepository.save(post);

        //transfer to DTO then return
        return postToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }
}
