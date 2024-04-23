package com.learnings.app.ws.userservice.impl;

import com.learnings.app.ws.ui.model.request.UserDetailsRequestModel;
import com.learnings.app.ws.ui.model.response.UserRest;
import com.learnings.app.ws.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
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
        return newUser;
    }
}
