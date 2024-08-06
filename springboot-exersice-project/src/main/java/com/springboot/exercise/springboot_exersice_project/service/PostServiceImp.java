package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreatePostRq;
import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.exception.ResourceNotFoundException;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;

import jakarta.transaction.Transactional;


@Service
public class PostServiceImp implements PostService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<GetPostRs> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                    .map(post -> this.settingDto(post))
                    .toList();
    }

    @Override
    public GetPostRs getPost(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("postId " + id + " not found")
        );

        return this.settingDto(post);
    }

    @Override
    public GetPostRs createPost(CreatePostRq body) {
        Post post = new Post();
        post.setTitle(body.getTitle());
        post.setBody(body.getBody());

        Integer userId = body.getUserId();
        UserDetails userDetails = userDetailsRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("userId " + userId + " not found" )
        );
        post.setUserDetails(userDetails);
        post.setComment(null);
        
        postRepository.save(post);

        return this.settingDto(post); 
    }

    @Override
    @Transactional
    public void deletePost(Integer id) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("postId " + id + " not found" )
            );
            postRepository.delete(post);
        } else {
            throw new ResourceNotFoundException("commentId " + id + " not found");
        }
    }

    @Override
    @Transactional
    public GetPostRs updatePostTitle(Integer id, CreatePostRq body) {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("postId " + id + " not found")
        );

        post.setTitle(body.getTitle());
        postRepository.save(post);

        Comment comment = post.getComment();
        if (comment != null) {
            comment.setTitle("re:" + body.getTitle());
            commentRepository.save(comment);
        }

        return this.settingDto(post);
    }

    private GetPostRs settingDto(Post post) {
        GetPostRs postGetDto = new GetPostRs();
        postGetDto.setBody(post.getBody());
        postGetDto.setCommentId(post.getComment() != null ? post.getComment().getId() : null);
        postGetDto.setId(post.getId());
        postGetDto.setTitle(post.getTitle());
        postGetDto.setUserId(post.getUserDetails() != null ? post.getUserDetails().getId() : null);

        return postGetDto;
    }
}
