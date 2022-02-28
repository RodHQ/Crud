package com.rodd331.crud.impl.v1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
@Builder
public class UserResponse {

    private String id;

    @NotBlank
    @Size(min = 4, max = 20, message = "min 4 max 20 Caracteres")
    private String userName;

    @NotBlank
    @Email(message = "Invalid email")
    private String email;

    @NotBlank
    @Size(min = 3, max = 20, message = "min 3 max 20 Caracteres")
    private String userPassword;
}