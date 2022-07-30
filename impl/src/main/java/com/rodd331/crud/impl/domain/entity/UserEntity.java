package com.rodd331.crud.impl.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@lombok.Data
@Builder
public class UserEntity {

    private String id;
    private String userName;
    private String email;
    private String userPassword;
}