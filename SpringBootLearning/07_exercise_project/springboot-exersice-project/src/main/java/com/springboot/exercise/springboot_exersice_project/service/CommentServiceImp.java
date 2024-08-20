package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exercise.springboot_exersice_project.dto.GetCommentRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreateCommentRq;
import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.exception.ResourceNotFoundException;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;

import jakarta.transaction.Transactional;


@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<GetCommentRs> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                    .map(comment -> this.settingDto(comment))
                    .toList();
    }
    
    @Override
    public GetCommentRs getComment(Integer id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("commentId " + id + " not found")
        );

        return this.settingDto(comment);
    }

    @Override
    public GetCommentRs createComment(CreateCommentRq body) {
        Comment comment = new Comment();

        Integer postId = body.getPostId();
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new ResourceNotFoundException("postId " + postId + " not found" )
        );
        post.setComment(comment);
        comment.setPost(post);

        comment.setTitle("re:" + post.getTitle());
        comment.setBody(body.getBody());
            
        commentRepository.save(comment);

        return this.settingDto(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Integer id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("commentId " + id + " not found");
        }
    }

    @Override
    public GetCommentRs updateComment(Integer id, CreateCommentRq body) {
        Comment comment = commentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("commentId " + id + " not found")
        );

        comment.setBody(body.getBody());
        commentRepository.save(comment);

        return this.settingDto(comment);
    }

    private GetCommentRs settingDto(Comment comment) {
        GetCommentRs commentGetDto = new GetCommentRs();
        commentGetDto.setBody(comment.getBody());
        commentGetDto.setId(comment.getId());
        commentGetDto.setPostId(comment.getPost() != null ? comment.getPost().getId() : null);
        commentGetDto.setTitle(comment.getTitle());

        return commentGetDto;
    }
}
