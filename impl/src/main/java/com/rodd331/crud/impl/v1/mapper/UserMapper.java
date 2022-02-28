package com.rodd331.crud.impl.v1.mapper;

import com.rodd331.crud.impl.domain.entity.UserEntity;
import com.rodd331.crud.impl.v1.dto.request.UserRequest;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserResponse mapToUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .userPassword(userEntity.getUserPassword())
                .build();
    }

    public static UserEntity mapToUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .userName(userRequest.getUserName())
                .email(userRequest.getEmail())
                .userPassword(userRequest.getUserPassword())
                .build();
    }
}