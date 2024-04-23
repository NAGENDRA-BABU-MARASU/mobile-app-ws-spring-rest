package com.learnings.app.ws.ui.controller;

import com.learnings.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.learnings.app.ws.ui.model.request.UserDetailsRequestModel;
import com.learnings.app.ws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        String firstName = null;
        int firstNameLength = firstName.length();
        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "getUsers was called with page=" + page + " & limit=" + limit + " & sort=" + sort;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest newUser = new UserRest();
        newUser.setEmail(userDetails.getEmail());
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());
        String userId = UUID.randomUUID().toString();
        newUser.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, path = "/{userId}")
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
