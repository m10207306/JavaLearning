package com.springboot.exercise.springboot_exersice_project.service;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.dto.UserGetDto;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<UserGetDto> getAllUsers() {
        // return userDetailsRepository.findAll();

        List<UserDetails> userDetails = userDetailsRepository.findAll();
        
        return userDetails.stream()
                        .map(UserServiceImp::settingDto)
                        .collect(Collectors.toList());
    }

    @Override
    public UserGetDto getUser(Integer id) {
        // 想說也不一定要自定義一個 Exception, 就用既有的 ResponseStatusException, 然後改 response body foramt 就好
        UserDetails user = userDetailsRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + id + " not found")
        );

        return UserServiceImp.settingDto(user);
    }

    @Override
    public ResponseEntity<UserGetDto> createUser(UserDetails user) {
        UserDetails userSaved = userDetailsRepository.save(user);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(userSaved.getId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public UserGetDto getUserByBody(Map<String, Object> body) {
        UserDetails user;

        if (body.containsKey("id")) {
            Integer key = (Integer) body.get("id");
            user = userDetailsRepository.findById(key).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + key + " not found")
            );
        }
        else if (body.containsKey("name")) {
            String key = (String) body.get("name");
            user = userDetailsRepository.findByName(key).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserName " + key + " not found")
            );
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search key undefined");
        }
        
        return UserServiceImp.settingDto(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        if (userDetailsRepository.existsById(id)) {
            userDetailsRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 成功刪除返回 204 No Content
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + id + " not found");
        }
    }

    static private UserGetDto settingDto(UserDetails user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setId(user.getId());
        userGetDto.setBirthDate(user.getBirthDate());
        userGetDto.setName(user.getName());
        List<Integer> postIds = user.getPosts().stream()
                                    .map(post -> post.getId())
                                    .collect(Collectors.toList());
        userGetDto.setPosts(postIds);
        return userGetDto;
    }
}
