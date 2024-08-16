package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
     
    @GetMapping("/v1/person")
    public Person getFirstFersionOfPerson() {
        return new Person("Bob Charlie");
    }
    
    @GetMapping("/v2/person")
    public PersonV2 getSecondFersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
    
    @GetMapping(path = "/person", params = "version=1")
    public Person getFirstFersionOfPersonRequestParameter() {
        return new Person("Bob Charlie");
    }
    
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondFersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
    
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public Person getFirstFersionOfPersonRequestHeader() {
        return new Person("Bob Charlie");
    }
    
    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondFersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
    
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Person getFirstFersionOfPersonAcceptHeader() {
        return new Person("Bob Charlie");
    }
    
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondFersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
