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

import com.springboot.exercise.springboot_exersice_project.dto.PostGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.PostPostDto;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;


@Service
public class PostServiceImp implements PostService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<PostGetDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                    .map(PostServiceImp::settingDto)
                    .collect(Collectors.toList());
    }

    @Override
    public PostGetDto getPost(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "postId " + id + " not found")
        );

        return PostServiceImp.settingDto(post);
    }

    @Override
    public ResponseEntity<PostGetDto> createPost(PostPostDto body) {
        Post post = new Post();
        post.setTitle(body.getTitle());
        post.setBody(body.getBody());

        Integer userId = body.getUserId();
        UserDetails userDetails = userDetailsRepository.findById(userId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found" )
        );
        post.setUserDetails(userDetails);
        post.setComment(null);
        
        Post newPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/user/{userId}/post/{postId}")
                        .buildAndExpand(userId, newPost.getId())
                        .toUri();

        return ResponseEntity.created(location).body(PostServiceImp.settingDto(newPost)); 
    }

    static private PostGetDto settingDto(Post post) {
        PostGetDto postGetDto = new PostGetDto();
        postGetDto.setBody(post.getBody());
        postGetDto.setCommentId(post.getComment() != null ? post.getComment().getId() : null);
        postGetDto.setId(post.getId());
        postGetDto.setTitle(post.getTitle());
        postGetDto.setUserId(post.getUserDetails() != null ? post.getUserDetails().getId() : null);

        return postGetDto;
    }
}
