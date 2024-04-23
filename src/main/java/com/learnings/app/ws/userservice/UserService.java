package com.learnings.app.ws.userservice;

import com.learnings.app.ws.ui.model.request.UserDetailsRequestModel;
import com.learnings.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
