package com.rodd331.crud.impl.v1.mapper;

import com.rodd331.crud.impl.v1.dto.response.UserListResponse;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserListMapper {

    public static UserListResponse mapToUserListResponse(List<UserResponse> page) {
        List<UserResponse> collect = page.stream().map(userModel -> UserResponse.builder()
                .id(userModel.getId())
                .userName(userModel.getUserName())
                .email(userModel.getEmail())
                .userPassword(userModel.getUserPassword())
                .build()).collect(Collectors.toList());
        return Objects.requireNonNull(UserListResponse.builder()
                .userResponseList(collect)
                .elementsPerPage(collect.size())
                .build());
    }
}