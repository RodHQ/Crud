package com.rodd331.crud.impl.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@lombok.Data
@Builder
@Document(collection = "User")
public class UserEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String email;

    private String userPassword;
}