package com.challange.talkspace.dto.request;

import com.challange.talkspace.lib.FieldsValueMatch;

import javax.validation.constraints.Size;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    private String login;
    @Size(min = 5, max = 40)
    private String password;
    private String repeatPassword;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
