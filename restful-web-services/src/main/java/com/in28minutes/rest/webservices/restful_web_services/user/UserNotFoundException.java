package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)    // 指定 return code 是 404, 不然會是 500
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message); 
    }

}
