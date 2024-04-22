package com.learnings.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId){
        return "getUser was called with userId=" + userId;
    }

    @PostMapping
    public String createUser(){
        return "createUser was called";
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }
}
