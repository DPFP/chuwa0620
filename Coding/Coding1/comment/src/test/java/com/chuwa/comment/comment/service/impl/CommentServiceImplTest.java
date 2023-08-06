package com.chuwa.comment.comment.service.impl;

import com.chuwa.comment.comment.dao.CommentRepository;
import com.chuwa.comment.comment.dao.PostRepository;
import com.chuwa.comment.comment.entity.Comment;
import com.chuwa.comment.comment.entity.Post;
import com.chuwa.comment.comment.exception.BlogAPIException;
import com.chuwa.comment.comment.exception.ResourceNotFoundException;
import com.chuwa.comment.comment.payload.CommentDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;


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

    private Comment comment;
    private CommentDto commentDto;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("Comment test start...");
    }

    @BeforeEach
    void setUp() {
        logger.info("Set up each test...");
        this.comment = new Comment(1L, "lin", "lin@mail.com" ,"lin's comment");
        modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.post = new Post(1L, "post", "post", "lin's post", LocalDateTime.now(), LocalDateTime.now());
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
    public void testCreateComment_PostNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(
                new ResourceNotFoundException("post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, ()->commentService.createComment(1L, commentDto));
    }


    @Test
    void testGetCommentsByPostId() {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        Mockito.when(commentRepositoryMock.findByPostId(eq(1L))).thenReturn(commentList);

        List<CommentDto> commentDtoResponse = commentService.getCommentsByPostId(1L);
        Assertions.assertNotNull(commentDtoResponse);
        Assertions.assertEquals(1, commentDtoResponse.size());
        CommentDto ctoResponse = commentDtoResponse.get(0);
        Assertions.assertEquals(commentDto.getBody(), ctoResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), ctoResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), ctoResponse.getName());
    }


    @Test
    void testGetCommentById() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        CommentDto commentDtoResponse = commentService.getCommentById(1L, 2L);
        Assertions.assertNotNull(commentDtoResponse);
        Assertions.assertEquals(commentDto.getBody(), commentDtoResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentDtoResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentDtoResponse.getName());
    }

    @Test
    void testGetCommentById_PostNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, ()->commentService.getCommentById(1L, 2L));
    }

    @Test
    void testGetCommentById_CommentNotFound(){
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenThrow(new ResourceNotFoundException("comment", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, ()->commentService.getCommentById(1L, 2L));
    }

    @Test
    void testGetCommentById_CommentNotMatchPost(){
        Post post2 = new Post(2L, "post2", "post2", "lin's post2", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepositoryMock.findById(eq(2L))).thenReturn(Optional.of(post2));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));
        Assertions.assertThrows(BlogAPIException.class, ()->commentService.getCommentById(2L, 2L));
    }


    @Test
    void testUpdateComment() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        String newBody = "New" + comment.getBody();
        commentDto.setBody(newBody);

        Comment updateComment = new Comment();
        updateComment.setPost(post);
        updateComment.setId(comment.getId());
        updateComment.setEmail(comment.getEmail());
        updateComment.setName(comment.getName());
        updateComment.setBody(newBody);

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(updateComment);

        CommentDto commentDtoResponse = commentService.updateComment(1L, 2L, commentDto);

        Assertions.assertNotNull(commentDtoResponse);
        Assertions.assertEquals(commentDto.getBody(), commentDtoResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentDtoResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentDtoResponse.getName());
    }

    @Test
    void testDeleteComment() {
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 2L);

        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }
}