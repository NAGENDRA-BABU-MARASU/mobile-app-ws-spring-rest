package com.learnings.app.ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, message = "firstName must be minimum of 2 characters length")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, message = "lastName must not be less than 2 characters")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
