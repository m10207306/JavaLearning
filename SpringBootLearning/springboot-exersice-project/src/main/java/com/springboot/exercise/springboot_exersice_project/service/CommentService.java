package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import com.springboot.exercise.springboot_exersice_project.dto.GetCommentRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreateCommentRq;

public interface CommentService {
    public List<GetCommentRs> getAllComment();
    public GetCommentRs getComment(Integer id);

    public GetCommentRs createComment(CreateCommentRq body);

    public void deleteComment(Integer id);

    public GetCommentRs updateComment(Integer id, CreateCommentRq body);
}
