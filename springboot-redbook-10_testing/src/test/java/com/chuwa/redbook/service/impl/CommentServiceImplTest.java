package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private static final Logger logger = Logger.getLogger("CommentServiceImplTest.class");
    @Spy
    private ModelMapper mapper;
    private Comment comment;
    private CommentDto commentDto;
    private Post post;
    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeAll
    static void beforeAll(){
        logger.info("Start Testing!");
    }

    @BeforeEach
    void setUp(){
        logger.info("Setting up each test cases");
        this.comment = new Comment(1L,"yg","yg@gmail.com","My comment");
        this.commentDto = mapper.map(this.comment, CommentDto.class);
        this.post = new Post(1L,"A Post","Just a post","content", LocalDateTime.now(),LocalDateTime.now());
        this.comment.setPost(this.post);
    }
    @Test
    void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(1L)).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(comment);
        CommentDto createCommentResponse = commentService.createComment(1L,commentDto);
        Assertions.assertNotNull(createCommentResponse);
        Assertions.assertEquals(commentDto, commentService.createComment(1L,commentDto));
    }

    @Test
    void testCreateComment_ThrowException(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id",1L));
        Assertions.assertThrows(ResourceNotFoundException.class,()->commentService.createComment(1L,commentDto));
    }

    @Test
    void getCommentsByPostId() {
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong())).thenReturn(List.of(comment));
        List<CommentDto> commentsByPostIdResponse = commentService.getCommentsByPostId(1L);
        Assertions.assertNotNull(commentsByPostIdResponse);
        //here the equals() method is overridden!!! this is great
        System.out.println(commentDto.equals(commentsByPostIdResponse.get(0)));
        Assertions.assertEquals(commentsByPostIdResponse.get(0),commentDto);
    }

    @Test
    void getCommentById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));
        CommentDto commentByIdResponse = commentService.getCommentById(1L, 1L);
        Assertions.assertNotNull(commentByIdResponse);
        Assertions.assertEquals(commentDto,commentByIdResponse);
    }

    @Test
    void getCommentById_PostIdNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id",1L));
        Assertions.assertThrows(ResourceNotFoundException.class, ()->commentService.getCommentById(1L,1L));
    }

    @Test
    void getCommentById_CommentIdNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, ()->commentService.getCommentById(1L,1L));
    }

    @Test
    void getCommentById_CommentNotBelongToPost(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        comment.setPost(new Post(2L,"","","",LocalDateTime.now(),LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Assertions.assertThrows(BlogAPIException.class, ()->commentService.getCommentById(1L,1L));
    }

    @Test
    void updateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        CommentDto commentDtoRequest = new CommentDto();
        commentDtoRequest.setId(commentDto.getId());
        commentDtoRequest.setBody(comment.getBody() + " 2.0");
        commentDtoRequest.setEmail(comment.getEmail());
        commentDtoRequest.setName(comment.getName());
        Comment newComment = mapper.map(commentDtoRequest, Comment.class);
        newComment.setId(comment.getId());
        newComment.setPost(post);

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(newComment);
        CommentDto updateCommentResponse = commentService.updateComment(1L, 1L, commentDtoRequest);

        assertNotNull(updateCommentResponse);
        assertEquals(updateCommentResponse, commentDtoRequest);
    }

    @Test
    void updateComment_PostNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id",1L));
        assertThrows(ResourceNotFoundException.class,()->commentService.updateComment(1L,1L,commentDto));
    }
    @Test
    void updateComment_CommentNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment","id",1L));
        assertThrows(ResourceNotFoundException.class,()->commentService.updateComment(1L,1L,commentDto));
    }

    @Test
    void updateComment_CommentDoesNotBelongToPost(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        comment.setPost(new Post(2L,"","","",LocalDateTime.now(),LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Assertions.assertThrows(BlogAPIException.class, ()->commentService.updateComment(1L,1L,commentDto));
    }

    @Test
    void deleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));
        commentService.deleteComment(1L,1L);
        Mockito.verify(commentRepositoryMock,Mockito.times(1)).delete(comment);
    }

    @Test
    void deleteComment_PostNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id",1L));
        assertThrows(ResourceNotFoundException.class,()->commentService.deleteComment(1L,1L));
    }

    @Test
    void deleteComment_CommentNotFound(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment","id",1L));
        assertThrows(ResourceNotFoundException.class,()->commentService.deleteComment(1L,1L));
    }

    @Test
    void deleteComment_CommentDoesNotBelongToPost(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));
        comment.setPost(new Post(2L,"","","",LocalDateTime.now(),LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Assertions.assertThrows(BlogAPIException.class, ()->commentService.deleteComment(1L,1L));
    }
}