package com.springboot.exercise.springboot_exersice_project.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")   // 避免無限遞迴的問題
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    @Schema(description = "此貼文的 title", example = "Post title")
    private String title;
    
    @Schema(description = "此貼文的 body", example = "Post body")
    private String body;

    @ManyToOne
    private UserDetails userDetails;
    // TODO: 也可以用 PreRemove

    /*
     * 這裡的寫法(沒有mappedby, comment那邊也沒寫)似乎不太常見，
     * 因為這代表 post 有一個 comment_id, comment 有一個 post_id
     * 
     * 通常會選選擇一方為主要, 不存在外鍵, 另一方儲存外鍵, 如下
     * @OneToOne(mappedby = "post")
     * private Comment comment;
     * 
     * 這邊表示 post 的 comment 是 Post 的 comment 屬性是被 Comment 的 post 屬性管理
     * 因此 Post 不會擁有 comment 的外鍵
     * 
     * 另一邊寫
     * @OneToOne
     * @JoinColumn(name = "post_id")
     * private Post post;
     * 
     * 表示 Comment 會擁有 post_id 這個 column 來管理這個 OneToOne 的關係
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;

    public Post() {
    }
    public Post(Integer id, String title, String body, UserDetails userDetails, Comment comment) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userDetails = userDetails;
        this.comment = comment;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", body=" + body + ", userDetails=" + userDetails + ", comment="
                + comment + "]";
    }
}
