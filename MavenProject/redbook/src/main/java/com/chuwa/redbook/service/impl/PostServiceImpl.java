package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;

import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        // convert DTO to entity
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        Post post = DtoToPost(postDto);
        Post newPost = postRepository.save(post);
        // convert entity to DTO
//        PostDto postResponse = new PostDto();
//        postResponse.setId(newPost.getId());
//        postResponse.setTitle(newPost.getTitle());
//        postResponse.setDescription(newPost.getDescription());
//        postResponse.setContent(newPost.getContent());

        PostDto postResponse = postToDto(newPost);
        return postResponse;
    }

    @Override

    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {


        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> postToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

//    @Override
//    public List<PostDto> getAllPost() {
//        List<Post> posts = postRepository.findAll();
//        List<PostDto> postDtos = new ArrayList<>();
////        for(Post post : posts){
////            PostDto response = postToDto(post);
////
////            postDtos.add(response);
////
////        }
////        return postDtos;
//        return posts.stream().map(post -> postToDto(post)).collect(Collectors.toList());
//    }


    @Override
    public PostDto getPostById(long id) {

//        Post post = postRepository.findById(id).get();
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return postToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return postToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);

    }

    private static PostDto postToDto(Post post) {
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setContent(post.getContent());
        return response;
    }

    private static Post DtoToPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
