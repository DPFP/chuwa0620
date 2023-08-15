package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.CommentDto;
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
        logger.info("Start test");
    }

    @BeforeEach
    void setUp() {
        logger.info("Set up");
        this.post = new Post(1L, "test post", "test post", "this is a test post",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L, "Bob", "bob@email.com" ,"this is a test comment",
                this.post, LocalDateTime.now(), LocalDateTime.now());
        modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
    }

    @Test
    public void testCreateComment(){
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
    public void testGetCommentsByPostId(){
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
    public void testGetCommentById(){
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).
                thenReturn(Optional.of(comment));

        CommentDto commentDtoResponse = commentService.getCommentById(1L, 2L);
        Assertions.assertNotNull(commentDtoResponse);
        Assertions.assertEquals(commentDto.getBody(), commentDtoResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentDtoResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentDtoResponse.getName());
    }

    @Test
    public void testUpdateComment(){
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).
                thenReturn(Optional.of(comment));

        String newBody = "New" + comment.getBody();
        commentDto.setBody(newBody);

        Comment updateComment = new Comment();
        updateComment.setPost(post);
        updateComment.setId(comment.getId());
        updateComment.setEmail(comment.getEmail());
        updateComment.setName(comment.getName());
        updateComment.setBody(newBody);

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updateComment);

        CommentDto commentDtoResponse = commentService.
                updateComment(1L, 2L, commentDto);

        Assertions.assertNotNull(commentDtoResponse);
        Assertions.assertEquals(commentDto.getBody(), commentDtoResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentDtoResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentDtoResponse.getName());
    }

    @Test
    public void testDeleteComment(){
        Mockito.when(postRepositoryMock.findById(eq(1L))).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 2L);

        Mockito.verify(commentRepositoryMock, Mockito.times(1))
                .delete(ArgumentMatchers.any(Comment.class));
    }
}
