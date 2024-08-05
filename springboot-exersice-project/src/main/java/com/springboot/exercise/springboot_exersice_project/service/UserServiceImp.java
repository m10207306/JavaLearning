package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.exercise.springboot_exersice_project.dto.GetUserRs;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public List<GetUserRs> getAllUsers() {
        // return userDetailsRepository.findAll();

        List<UserDetails> userDetails = userDetailsRepository.findAll();
        
        return userDetails.stream()
                        .map(user -> this.settingDto(user))
                        .toList();
    }

    // TODO: 還是建立一個 ResourceNotFoundException
    @Override
    public GetUserRs getUser(Integer id) {
        // 想說也不一定要自定義一個 Exception, 就用既有的 ResponseStatusException, 然後改 response body foramt 就好
        UserDetails user = userDetailsRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "userId " + id + " not found")
        );

        return this.settingDto(user);
    }

    @Override
    public GetUserRs createUser(UserDetails user) {
        return this.settingDto(userDetailsRepository.save(user));
    }

    @Override
    public GetUserRs getUserByBody(String id, String name) {
        UserDetails user;

        if (id != null) {
            Integer key = Integer.parseInt(id);
            user = userDetailsRepository.findById(key).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "userId " + key + " not found")
            );
        }
        else if (name != null) {
            user = userDetailsRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "userName " + name + " not found")
            );
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search key undefined");
        }
        
        return this.settingDto(user);
    }

    // TODO: delete, 跨 table 操作, custom 的 repository delete function 都要加 @Transactional
    @Override
    @Transactional
    public void deleteUser(Integer id) {
        if (userDetailsRepository.existsById(id)) {
            userDetailsRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "userId " + id + " not found");
        }
    }

    // TODO: 不用 static
    private GetUserRs settingDto(UserDetails user) {
        GetUserRs userGetDto = new GetUserRs();
        userGetDto.setId(user.getId());
        userGetDto.setBirthDate(user.getBirthDate());
        userGetDto.setName(user.getName());
        userGetDto.setPosts(user.getPosts()
                                .stream()
                                .map(post -> post.getId())
                                .toList()
                            );
        return userGetDto;
    }
}
