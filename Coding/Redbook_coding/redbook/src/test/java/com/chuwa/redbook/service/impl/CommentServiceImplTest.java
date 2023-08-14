package com.chuwa.redbook.service.impl;
import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

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

    private PostDto postDto;
    public Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");
        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(5L, "heihei", "hh@gmail.com", "nice", this.post, LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.postDto = modelMapper.map(this.post, PostDto.class);
    }

    @Test
    public void testCreateComment() {
        // define the behaviors
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(post));
        // execute
        CommentDto commentResponse = commentService.createComment(1l, commentDto);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        // define the behaviors
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong())).thenReturn(comments);

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
    public void testGetCommentById() {
        // define the behaviors
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        // execute
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testGetCommentById_ResourceNotFoundException() {
        // define the behaviors
        //Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
        //        .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L,1L));
    }

    @Test
    public void testUpdateComment() {
        String body = "UPDATED - " + comment.getBody();
        postDto.setDescription(body);

        // deep copy
        Comment updatedComment = new Comment();
        updatedComment.setId(comment.getId());
        updatedComment.setName(comment.getName());
        updatedComment.setBody(body);
        updatedComment.setEmail(comment.getEmail());

        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updatedComment);

        // execute
        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        // assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals("UPDATED - "+commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testUpdatePost_ResourceNotFoundException() {
        // define the behaviors
//        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
//                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L,1L, commentDto));
    }

    @Test
    public void testGetCommentById_BlogAPIException(){
        Post fakePost = new Post(66L);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(fakePost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        //Mockito.when(post.getId()).thenReturn(new Long(2L));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L,1L));

    }

    @Test
    public void testUpdateComment_BlogAPIException(){
        Post fakePost = new Post(66L);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(fakePost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        //Mockito.when(post.getId()).thenReturn(new Long(2L));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L,1L, commentDto));

    }

    @Test
    public void testDeleteComment_BlogAPIException(){
        Post fakePost = new Post(66L);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(fakePost));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        //Mockito.when(post.getId()).thenReturn(new Long(2L));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L,1L));

    }

    @Test
    public void testDeleteComment() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));
        // postRepositoryMock.delete() is a void method
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        // execute
        commentService.deleteComment(1l, 1l);

        // verify
        // 验证 postRepositoryMock.delete() 被执行过一次
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteComment_Post_ResourceNotFoundException() {
        // define the behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L,1L));

    }

    @Test
    public void testDeleteComment_Comment_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(post));

        // define the behaviors
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        // execute and assertions
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L,1L));

    }


}
