package com.in28minutes.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Post {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min = 10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserJPA user;

    public Post() {
    }

    public Post(Integer id, @Size(min = 10) String description, UserJPA user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public UserJPA getUser() {
        return user;
    }

    public void setUser(UserJPA user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + "]";
    }
}
