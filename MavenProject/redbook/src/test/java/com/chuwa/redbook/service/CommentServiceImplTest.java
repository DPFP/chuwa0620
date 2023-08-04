package com.chuwa.redbook.service;


import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.impl.CommentServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);
    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;
    private CommentDto commentDto;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("Start test...");
    }

    @BeforeEach
    void setUp() {
        logger.info("Setting up each test");
        this.comment = new Comment(1L, "xilin", "xilin@mail.com" ,"this is a comment");
        modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.post = new Post(1L, "Post!", "post", "this is a post", LocalDateTime.now(), LocalDateTime.now());
        this.comment.setPost(post);
    }

    @Test
    public void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDto commentResponse = commentService.createComment(1L,commentDto);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }

    @Test
    public void testCreateCommentNotFoundPost() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("post","id",1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(2L, commentDto));
    }

    @Test
    public void testGetCommentById() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        CommentDto response = commentService.getCommentById(1L,1L);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getName(), commentDto.getName());
        Assertions.assertEquals(response.getEmail(), commentDto.getEmail());
        Assertions.assertEquals(response.getBody(), commentDto.getBody());
    }

    @Test
    public void testGetCommentByIdPostNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("post","id",1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(2L, 2L));
    }

    @Test
    public void testGetCommentByIdCommentNotFound() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("comment","id",1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testGetCommentByIdCommentDoesNotBelongToPost() {
        Post secondPost = new Post(2L, "Post!", "post", "this is a post", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(secondPost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        List<CommentDto> response = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        CommentDto cto = response.get(0);
        Assertions.assertEquals(cto.getName(), commentDto.getName());
        Assertions.assertEquals(cto.getEmail(), commentDto.getEmail());
        Assertions.assertEquals(cto.getBody(), commentDto.getBody());
    }

    @Test
    public void testUpdateComment() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        String updatedBody = "Updated" + comment.getBody();
        commentDto.setBody(updatedBody);

        Comment updatedComment = new Comment();
        updatedComment.setPost(post);
        updatedComment.setId(comment.getId());
        updatedComment.setName(comment.getName());
        updatedComment.setEmail(comment.getEmail());
        updatedComment.setBody(updatedBody);

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updatedComment);

        CommentDto response = commentService.updateComment(1L,1L,commentDto);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(commentDto.getBody(), response.getBody());
        Assertions.assertEquals(commentDto.getEmail(), response.getEmail());
        Assertions.assertEquals(commentDto.getName(), response.getName());
    }

    @Test
    public void testUpdateCommentCommentDoesNotBelongToPost() {
        Post secondPost = new Post(2L, "Post!", "post", "this is a post", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(secondPost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    public void testUpdateCommentCommentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("post","id",1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(2L, 2L, commentDto));
    }

    @Test
    public void testUpdateCommentPostNotFound() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("comment","id",1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    public void testDeleteComment() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L,2L);

        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteCommentCommentDoesNotBelongToPost() {
        Post secondPost = new Post(2L, "Post!", "post", "this is a post", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(secondPost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));
    }
}
