package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    @InjectMocks
    private PostServiceImpl postService;


    private PostDto postDto;
    private Post post;
    private CommentDto commentDto;
    private Comment comment;

    @BeforeAll
    static void beforeAll() {
        log.info("start test");
    }

    @BeforeEach
    void setUp() {
        log.info(("set up comment for test"));

        this.comment = new Comment(1L, "name", "email", "body");
        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        comment.setPost(post);

        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.postDto = modelMapper.map(this.post, PostDto.class);
    }

    @Test
    public void testCreateComment() {
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());

    }

    @Test
    public void testCreateComment_PostNotFound() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));

    }

    @Test
    public void testGetCommentByPostId() {
        Mockito.when(commentRepository.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(Arrays.asList(comment));

        List<CommentDto> commentDtoList = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(commentDtoList);
        Assertions.assertEquals(1, commentDtoList.size());
        CommentDto commentResponse = commentDtoList.get(0);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }

    @Test
    public void testGetCommentById() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }

    @Test
    public void testGetCommentById_PostNotFound() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testGetCommentById_CommentNotFound() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testGetCommentById_CommentPostNotMatch() {
        Post secondPost = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(secondPost));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));
    }


    @Test
    public void testUpdateComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        Comment newComment = new Comment(1L, "newName", "newEmail", "newBody");

        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(newComment);

        commentDto.setBody("newBody");
        commentDto.setEmail("newEmail");
        commentDto.setName("newName");

        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }

    @Test
    public void testDeleteComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        Mockito.doNothing().when(commentRepository).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 1L);

        Mockito.verify(commentRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));

    }
}
