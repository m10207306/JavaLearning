package com.springboot.exercise.springboot_exersice_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;

public class PostServiceImpTest {

    private static PostServiceImp postServiceImp = new PostServiceImp();
    private static Method settingDtoMethod;

    @BeforeAll
    public static void init() throws Exception {
        // 將 private function 臨時性設為 public
        settingDtoMethod = PostServiceImp.class.getDeclaredMethod("settingDto", Post.class);
        settingDtoMethod.setAccessible(true);
    }

    @Test
    public void settingDtoTest_normalCase() throws Exception {
        UserDetails userDetails = new UserDetails(1, "Derick", LocalDate.now().minusDays(1), new ArrayList<>());
        Post post = new Post(1, "title", "body", userDetails, null);
        Comment comment = new Comment(1, post, "body", null);
        post.setComment(comment);
        
        GetPostRs rs = (GetPostRs) settingDtoMethod.invoke(postServiceImp, post);

        assertEquals(post.getId(), rs.getId());
        assertEquals(post.getTitle(), rs.getTitle());
        assertEquals(post.getBody(), rs.getBody());
        assertEquals(post.getUserDetails().getId(), rs.getUserId());
        assertEquals(post.getComment().getId(), rs.getCommentId());
    }

    @Test
    public void settingDtoTest_withoutRelation() throws Exception {
        Post post = new Post(1, "title", "body", null, null);
        
        GetPostRs rs = (GetPostRs) settingDtoMethod.invoke(postServiceImp, post);

        assertEquals(post.getId(), rs.getId());
        assertEquals(post.getTitle(), rs.getTitle());
        assertEquals(post.getBody(), rs.getBody());
        assertEquals(post.getUserDetails(), rs.getUserId());
        assertEquals(post.getComment(), rs.getCommentId());
    }
}
