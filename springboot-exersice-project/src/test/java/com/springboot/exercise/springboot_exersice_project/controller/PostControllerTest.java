package com.springboot.exercise.springboot_exersice_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.service.PostService;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    MockMvc mockMvc;

    @Mock
    PostService postService;

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostController postController;

    @Test
    void testCreatePost() {

    }

    @Test
    void testDeletePost() {

    }

    @Test
    void testGetAllPost() throws Exception {
        // UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now(), new ArrayList<>());
        // Post post1 = new Post(1, "title1", "body1", userDetails, null);
        // Post post2 = new Post(2, "title2", "body2", userDetails, null);
        // List<Post> posts = List.of(post1, post2);
        // userDetails.setPosts(posts);

        // when(postRepository.findAll()).thenReturn(posts);

        // System.out.println(postRepository.findAll());
        
        // MvcResult result = mockMvc.perform(get("/posts"))
        //                             .andExpect(status().isOk())
        //                             .andReturn();

        // String response = result.getResponse().getContentAsString();
        // List<GetPostRs> postsRs = new ObjectMapper().readValue(response, new TypeReference<List<GetPostRs>>() {});

        // assertEquals(2, postsRs.size());
        // assertEquals("title1", postsRs.get(0).getTitle());
        // assertEquals("title2", postsRs.get(1).getTitle());
    }

    @Test
    void testGetPost() {

    }

    @Test
    void testUpdatePostTitle() {

    }
}
