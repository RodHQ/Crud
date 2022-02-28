package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.service.UserService;
import com.rodd331.crud.impl.v1.dto.request.UserRequest;
import com.rodd331.crud.impl.v1.dto.response.UserListResponse;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.rodd331.crud.impl.v1.mapper.UserListMapper.mapToUserListResponse;
import static com.rodd331.crud.impl.v1.mapper.UserMapper.mapToUserEntity;
import static com.rodd331.crud.impl.v1.mapper.UserMapper.mapToUserResponse;

@Component
@AllArgsConstructor
public class UserFacade {

    private final UserService userService;

    public UserResponse create(UserRequest user) {
        return mapToUserResponse(userService.create(mapToUserEntity(user)));
    }

    public UserListResponse allUsers(int page) {
        userService.validationEmptyList();
        return mapToUserListResponse(userService.listAll(page));
    }

    public UserResponse findById(String id) {
        return mapToUserResponse(userService.findById(id));
    }

    public UserResponse update(UserRequest user, String id) {
        userService.validatorId(id);
        return mapToUserResponse(userService.update(mapToUserEntity(user), id));
    }

    public void delete(String id) {
        userService.validatorId(id);
        userService.delete(id);
    }
}