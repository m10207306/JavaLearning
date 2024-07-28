package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class UserJPA {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @JsonProperty("user_name")  // 自定義 response json property name
    private String name;

    @Past(message = "Birth day should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public UserJPA() {
    }

    public UserJPA(Integer id, @Size(min = 2, message = "Name should have at least 2 characters") String name,
            @Past(message = "Birth day should be in the past") LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserJPA [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }

}
