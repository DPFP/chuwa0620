package com.chuwa.redbook.service.imlp;

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
        Post newPost = new Post();
        newPost.setId(postDto.getId());
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setContent(postDto.getContent());
        Post savedPost = this.postRepository.save(newPost);
        PostDto response = getPostDto(savedPost);
        return response;
    }

    private static PostDto getPostDto(Post savedPost) {
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setDescription(savedPost.getDescription());
        response.setContent(savedPost.getContent());
        return response;
    }

    @Override
    public List<PostDto> getAllPost(){
        List<Post> posts = postRepository.findAll();

    return posts.stream().map(post->this.getPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id", String.valueOf(id)));

        return this.getPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id){
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id", String.valueOf(id)));
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        Post updatedPost = postRepository.save(post);

        return getPostDto(updatedPost);
    }

    @Override
    public PostDto deletePostById(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id", String.valueOf(id)));
        postRepository.delete(post);
        return getPostDto(post);
    }
}
