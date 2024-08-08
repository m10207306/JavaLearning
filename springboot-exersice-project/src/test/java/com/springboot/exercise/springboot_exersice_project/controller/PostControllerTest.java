package com.springboot.exercise.springboot_exersice_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.exercise.springboot_exersice_project.dto.CreatePostRq;
import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @BeforeEach
    public void setup() {
        postRepository.deleteAll();
        userDetailsRepository.deleteAll();
    }

    @Test
    void testCreatePost_paramCorrect() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);

        CreatePostRq rqBody = new CreatePostRq();
        rqBody.setUserId(userDetails.getId());
        rqBody.setTitle("title");
        rqBody.setBody("body");
        String rqBodyStr = objectMapper.writeValueAsString(rqBody);
        
        MvcResult result =  mockMvc.perform(post("/posts").contentType("application/json").content(rqBodyStr))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(userDetails.getId()))
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.body").value("body"))
                .andExpect(jsonPath("$.userId").value(userDetails.getId()))
                .andExpect(jsonPath("$.commentId").isEmpty())
                .andReturn();

        String rsBodyStr = result.getResponse().getContentAsString();
        GetPostRs rsBody = objectMapper.readValue(rsBodyStr, GetPostRs.class);

        // 檢查 DB 資料正確
        Post post = postRepository.findById(userDetails.getId()).get();
        assertEquals(rsBody.getId(), post.getId());
        assertEquals("title", post.getTitle());
        assertEquals("body", post.getBody());
        assertEquals(userDetails.getId(), post.getUserDetails().getId());
        assertEquals(null, post.getComment());
    }

    @Test
    void testCreatePost_paramMissing() throws Exception {        
        CreatePostRq rqBody = new CreatePostRq();
        rqBody.setUserId(1);
        // 缺乏必要參數 title
        rqBody.setBody("body");
        String rqBodyStr = objectMapper.writeValueAsString(rqBody);

        mockMvc.perform(post("/posts").contentType("application/json").content(rqBodyStr))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeletePost_dataFound() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);
        
        Post post = new Post(1, "title", "body", userDetails, null);
        post = postRepository.save(post);
        
        mockMvc.perform(delete("/posts/" + post.getId()))
        .andExpect(status().isNoContent());
        
        Optional<Post> parsedPost = postRepository.findById(post.getId());
        assertEquals(Optional.empty(), parsedPost);
        
        // 確認 userdetails 的 one-to-many 欄位中沒有 post
        userDetails = userDetailsRepository.findById(userDetails.getId()).get();
        assertEquals(0, userDetails.getPosts().size());
    }

    @Test
    void testDeletePost_dataNotFound() throws Exception {
        mockMvc.perform(delete("/posts/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetAllPost_withPosts() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);

        Post post1 = new Post(1, "title1", "body1", userDetails, null);
        Post post2 = new Post(2, "title2", "body2", userDetails, null);
        post1 = postRepository.save(post1);
        post2 = postRepository.save(post2);
        
        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(post1.getId()))
                .andExpect(jsonPath("$[0].title").value("title1"))
                .andExpect(jsonPath("$[0].body").value("body1"))
                .andExpect(jsonPath("$[0].userId").value(userDetails.getId()))
                .andExpect(jsonPath("$[0].commentId").isEmpty())
                .andExpect(jsonPath("$[1].id").value(post2.getId()))
                .andExpect(jsonPath("$[1].title").value("title2"))
                .andExpect(jsonPath("$[1].body").value("body2"))
                .andExpect(jsonPath("$[1].userId").value(userDetails.getId()))
                .andExpect(jsonPath("$[1].commentId").isEmpty());
    }

    @Test
    void testGetAllPost_noPosts() throws Exception {
        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testGetPost_withPost() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);

        Post post1 = new Post(1, "title1", "body1", userDetails, null);        
        post1 = postRepository.save(post1);

        mockMvc.perform(get("/posts/" + post1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post1.getId()))
                .andExpect(jsonPath("$.title").value("title1"))
                .andExpect(jsonPath("$.body").value("body1"))
                .andExpect(jsonPath("$.userId").value(userDetails.getId()))
                .andExpect(jsonPath("$.commentId").isEmpty());
    }

    @Test
    void testGetPost_noPost() throws Exception {
       mockMvc.perform(get("/posts/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdatePostTitle_paramCorrect() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);

        Post post1 = new Post(1, "title1", "body1", userDetails, null);
        post1 = postRepository.save(post1);

        CreatePostRq rqBody = new CreatePostRq();
        rqBody.setTitle("title2");
        String rqBodyStr = objectMapper.writeValueAsString(rqBody);

        mockMvc.perform(put("/posts/" + post1.getId() + "/title").contentType("application/json").content(rqBodyStr))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("title2"));
    }
    
    @Test
    void testUpdatePostTitle_paramMissing() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        userDetails = userDetailsRepository.save(userDetails);

        Post post1 = new Post(1, "title1", "body1", userDetails, null);
        post1 = postRepository.save(post1);
        
        CreatePostRq rqBody = new CreatePostRq();
        String rqBodyStr = objectMapper.writeValueAsString(rqBody);

        mockMvc.perform(put("/posts/" + post1.getId() + "/title").contentType("application/json").content(rqBodyStr))
                .andExpect(status().isBadRequest());
    }
}
