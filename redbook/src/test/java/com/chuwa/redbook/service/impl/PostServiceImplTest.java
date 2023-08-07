package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    private PostDto postDto;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.postDto = modelMapper.map(this.post, PostDto.class);
    }

    @Test
    public void testCreatePost() {
        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(post);

        PostDto postResponse = postService.createPost(postDto);
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetAllPost() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        Mockito.when(postRepositoryMock.findAll())
                .thenReturn(posts);
        List<PostDto> postDtos = postService.getAllPost();

        Assertions.assertNotNull(postDtos);
        Assertions.assertEquals(1, postDtos.size());
        PostDto postResponse = postDtos.get(0);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetPostById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        PostDto postResponse = postService.getPostById(1L);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetPostById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1L));
    }

    @Test
    public void testUpdatePost() {
        String description = "UPDATED - " + post.getDescription();
        postDto.setDescription(description);

        Post updatedPost = new Post();
        updatedPost.setId(post.getId());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setDescription(description);
        updatedPost.setContent(post.getContent());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(updatedPost);

        PostDto postResponse = postService.updatePostById(postDto, 1L);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testUpdatePost_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.updatePostById(postDto,1L));
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.doNothing().when(postRepositoryMock).delete(ArgumentMatchers.any(Post.class));

        postService.deletePostById(1L);

        Mockito.verify(postRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Post.class));
    }

    @Test
    public void testDeletePostById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.deletePostById(1L));
    }

    @Test
    public void testGetAllPost_Pageable() {
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.ASC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pagePosts);

        PostResponse postResponse = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(pageNo, postResponse.getPageNo());
        Assertions.assertEquals(pageSize, postResponse.getPageSize());
        Assertions.assertEquals(totalElements, postResponse.getTotalElements());
        Assertions.assertEquals(totalPages, postResponse.getTotalPages());
        Assertions.assertEquals(isLast, postResponse.isLast());

        List<PostDto> content = postResponse.getContent();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(posts.size(), content.size());
        PostDto dto = content.get(0);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(postDto.getTitle(), dto.getTitle());
        Assertions.assertEquals(postDto.getDescription(), dto.getDescription());
        Assertions.assertEquals(postDto.getContent(), dto.getContent());
    }

    @Test
    public void testGetAllPost_Pageable_SortDirDescending() {
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.DESC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pagePosts);

        PostResponse postResponse = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(pageNo, postResponse.getPageNo());
        Assertions.assertEquals(pageSize, postResponse.getPageSize());
        Assertions.assertEquals(totalElements, postResponse.getTotalElements());
        Assertions.assertEquals(totalPages, postResponse.getTotalPages());
        Assertions.assertEquals(isLast, postResponse.isLast());

        List<PostDto> content = postResponse.getContent();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(posts.size(), content.size());
        PostDto dto = content.get(0);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(postDto.getTitle(), dto.getTitle());
        Assertions.assertEquals(postDto.getDescription(), dto.getDescription());
        Assertions.assertEquals(postDto.getContent(), dto.getContent());
    }

}
