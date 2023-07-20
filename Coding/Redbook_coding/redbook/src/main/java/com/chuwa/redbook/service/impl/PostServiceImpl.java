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
        //        Post post = new Post();
        //        if (postDto.getTitle() != null) {
        //            post.setTitle(postDto.getTitle());
        //        } else {
        //            post.setTitle("");
        //        }
        //        post.setDescription(postDto.getDescription());
        //        post.setContent(postDto.getContent());
        // covert DTO to Entity
        Post newPost = getPost(postDto);
        Post savedPost = this.postRepository.save(newPost);
        //        PostDto postResponse = new PostDto();
        //        postResponse.setId(savedPost.getId());
        //        postResponse.setTitle(savedPost.getTitle());
        //        postResponse.setDescription(savedPost.getDescription());
        //        postResponse.setContent(savedPost.getContent());
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
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePost = postRepository.findAll(pageRequest);
        List<Post> posts = pagePost.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> getPostDto(post)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pageNo);
        postResponse.setPageSize(pageSize);
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLast(pagePost.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(long Id) {
        //Optional<Post> post = postRepository.findById(id);
        //post.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //Post post = postRepository.findById(id).get();
        Post post = postRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", Id));
        return getPostDto(post);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Post", "Id", id));
        foundPost.setTitle(postDto.getTitle());
        foundPost.setDescription(postDto.getDescription());
        foundPost.setContect(postDto.getContent());

        Post updatedPost = postRepository.save(foundPost);
        return getPostDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Post", "Id", id));
        postRepository.delete(foundPost);
    }
}
