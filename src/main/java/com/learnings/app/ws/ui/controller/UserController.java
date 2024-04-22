package com.learnings.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "getUser was called with userId=" + userId;
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
