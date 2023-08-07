package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.Comment.CommentDto;
import com.chuwa.redbook.payload.Comment.CreateCommentDto;
import com.chuwa.redbook.payload.Post.PostDto;
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

/**
 * @author derri on 11/26/2022
 */
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

    @InjectMocks
    private PostServiceImpl postService;


    private Post post;
    private PostDto postDto;


    private Comment comment;
    private CommentDto commentDto;


    @BeforeAll
    static void beforeAll() { logger.info("START test");}
    @BeforeEach
    void setup() {
        logger.info("setting up for each test");
        ModelMapper modelMapper = new ModelMapper();

        this.post = new Post(1L, "test title", "test description", "test content",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L, "Tester1", "tester1@gmail.com", "this is a test comment", this.post, LocalDateTime.now(), LocalDateTime.now());
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
    }
    @Test
    void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CreateCommentDto commentResponse = commentService.createComment(1L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        // execute
        List<CommentDto> commentResponse = commentService.getCommentsByPostId(1L);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(1, commentResponse.size());
        CommentDto response = commentResponse.get(0);
        Assertions.assertEquals(commentDto.getBody(), response.getBody());
        Assertions.assertEquals(commentDto.getEmail(), response.getEmail());
        Assertions.assertEquals(commentDto.getName(), response.getName());

    }

    @Test
    void getCommentById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
    }



    @Test
    void testUpdateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        String newbody = "UPDATED - " + comment.getBody();
        commentDto.setBody(newbody);

        Comment updatedComment = new Comment();
        updatedComment.setId(comment.getId());
        updatedComment.setEmail(comment.getEmail());
        updatedComment.setName(comment.getName());
        updatedComment.setBody(body);
        updatedComment.setPost(post);

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updateComment);

        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());

    }


    @Test
    void deleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 1L);

        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

}