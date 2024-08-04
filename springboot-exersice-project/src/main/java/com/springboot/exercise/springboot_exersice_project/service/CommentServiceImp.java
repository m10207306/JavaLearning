package com.springboot.exercise.springboot_exersice_project.service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.dto.CommentGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.CommentPostDto;
import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;


@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentGetDto> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                    .map(CommentServiceImp::settingDto)
                    .collect(Collectors.toList());
    }
    
    @Override
    public CommentGetDto getComment(Integer id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "commentId " + id + " not found")
        );

        return CommentServiceImp.settingDto(comment);
    }

    @Override
    public ResponseEntity<CommentGetDto> createComment(CommentPostDto body) {
        Comment comment = new Comment();

        Integer postId = body.getPostId();
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "postId " + postId + " not found" )
        );
        post.setComment(comment);
        comment.setPost(post);

        comment.setTitle("re:" + post.getTitle());
        comment.setBody(body.getBody());
            
        Comment newComment = commentRepository.save(comment);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/post/{postId}/comment/{commentId}")
                        .buildAndExpand(postId, newComment.getId())
                        .toUri();

        return ResponseEntity.created(location).body(CommentServiceImp.settingDto(newComment));
    }

    static private CommentGetDto settingDto(Comment comment) {
        CommentGetDto commentGetDto = new CommentGetDto();
        commentGetDto.setBody(comment.getBody());
        commentGetDto.setId(comment.getId());
        commentGetDto.setPostId(comment.getPost() != null ? comment.getPost().getId() : null);
        commentGetDto.setTitle(comment.getTitle());

        return commentGetDto;
    }
}
