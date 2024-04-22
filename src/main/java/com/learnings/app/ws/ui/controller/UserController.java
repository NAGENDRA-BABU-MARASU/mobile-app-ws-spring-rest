package com.learnings.app.ws.ui.controller;

import com.learnings.app.ws.ui.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public UserRest getUser(@PathVariable String userId) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("Test@email.com");
        returnValue.setFirstName("test_firstname");
        returnValue.setLastName("test_lastname");
        return returnValue;
    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "getUsers was called with page=" + page + " & limit=" + limit + " & sort=" + sort;
    }

    @PostMapping
    public String createUser() {
        return "createUser was called";
    }

    @PutMapping
    public String updateUser() {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }
}
