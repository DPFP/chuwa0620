package com.example.redbook.service.impl;

import com.example.redbook.dao.PostRepository;
import com.example.redbook.entity.Post;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.PostDto;
import com.example.redbook.payload.PostResponse;
import com.example.redbook.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //PostDTO -> Post(entity)
        //Post newPost = new Post();
        //newPost.setTitle(postDto.getTitle());
        //newPost.setDescription(postDto.getDescription());
        //newPost.setContent(postDto.getContent());
        Post newPost = modelMapper.map(postDto, Post.class);
        Post savedPost = this.postRepository.save(newPost);

        //Post(entity) -> PostDTO
        //return PostToDto(savedPost);
        return modelMapper.map(savedPost, PostDto.class);

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
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        return modelMapper.map(post, PostDto.class);
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

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        // PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        // PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> PostToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }
}