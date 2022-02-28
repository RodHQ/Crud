package com.rodd331.crud.impl.v1.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@lombok.Data
public class UserRequest {

    @NotBlank(message = "Field needs to be filled")
    @Size(min = 4, max = 20, message = "min 4 max 20 characters")
    private String userName;

    @NotBlank(message = "Field needs to be filled")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Field needs to be filled")
    @Size(min = 3, max = 20, message = "min 3 max 20 characters")
    private String userPassword;
}