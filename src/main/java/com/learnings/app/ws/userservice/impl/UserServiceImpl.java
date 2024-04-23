package com.learnings.app.ws.userservice.impl;

import com.learnings.app.ws.shared.Utils;
import com.learnings.app.ws.ui.model.request.UserDetailsRequestModel;
import com.learnings.app.ws.ui.model.response.UserRest;
import com.learnings.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest newUser = new UserRest();
        newUser.setEmail(userDetails.getEmail());
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());
        String userId = utils.generateUserId();
        newUser.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, newUser);
        return newUser;
    }
}
