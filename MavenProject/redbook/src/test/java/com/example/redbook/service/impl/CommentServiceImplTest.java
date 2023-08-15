package com.example.redbook.service.impl;

import com.example.redbook.dao.CommentRepository;
import com.example.redbook.dao.PostRepository;
import com.example.redbook.entity.Comment;
import com.example.redbook.entity.Post;
import com.example.redbook.exception.BlogAPIException;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.CommentDto;
import com.example.redbook.payload.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository commentRepositoryMock;
    @Mock
    private PostRepository postRepositoryMock;
    @Spy
    private ModelMapper modelMapper;
    @InjectMocks
    private CommentServiceImpl commentService;

    private PostDto postDto;
    private Post post;
    private CommentDto commentDto;
    private Comment comment;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(1L, "this is titile", "this is des", "this is content", LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.postDto = modelMapper.map(this.post, PostDto.class);
        this.comment = new Comment(1, "MyName", "123@abc.com", "this is body");
        this.comment.setPost(this.post);
        this.commentDto =  modelMapper.map(this.comment, CommentDto.class);
    }

    @Test
    public void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDto commentResponse = commentService.createComment(1, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testCreateComment_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1, commentDto));
    }

    @Test
    public void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        // execute
        List<CommentDto> commentDtos = commentService.getCommentsByPostId(1L);

        // assertions
        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(1, commentDtos.size());
        CommentDto commentResponse = commentDtos.get(0);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testGetCommentsByPostId_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentsByPostId(1L));
    }

    @Test
    public void testGetCommentById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        // execute
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        // assertions
        Assertions.assertNotNull(commentDto);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testGetCommentById_ResourceNotFoundException_PostNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L,1L));
    }

    @Test
    public void testGetCommentById_ResourceNotFoundException_CommentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L,1L));
    }

    @Test
    public void testGetCommentById_BlogAPIException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(new Post(2L, "this is titile", "this is des", "this is content", LocalDateTime.now(), LocalDateTime.now())));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(2L,1L));
    }

    @Test
    public void testUpdateComment() {
        String updated_body = "This is updated body";
        commentDto.setBody(updated_body);

        Comment updatedComment = new Comment();
        updatedComment.setId(commentDto.getId());
        updatedComment.setName(commentDto.getName());
        updatedComment.setEmail(commentDto.getEmail());
        updatedComment.setBody(updated_body);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updatedComment);

        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);
        Assertions.assertNotNull(commentDto);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testUpdateComment_ResourceNotFoundException_PostNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L,1L, commentDto));
    }

    @Test
    public void testUpdateComment_ResourceNotFoundException_CommentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L,1L, commentDto));
    }

    @Test
    public void testUpdateComment_BlogAPIException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(new Post(2L, "this is titile", "this is des", "this is content", LocalDateTime.now(), LocalDateTime.now())));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(2L,1L, commentDto));
    }

    @Test
    public void testDeleteComment() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        // execute
        commentService.deleteComment(1L, 1L);

        // verify
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteComment_ResourceNotFoundException_PostNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L,1L));
    }

    @Test
    public void testDeleteComment_ResourceNotFoundException_CommentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L,1L));
    }

    @Test
    public void testDeleteComment_BlogAPIException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(new Post(2L, "this is titile", "this is des", "this is content", LocalDateTime.now(), LocalDateTime.now())));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(2L,1L));
    }
}