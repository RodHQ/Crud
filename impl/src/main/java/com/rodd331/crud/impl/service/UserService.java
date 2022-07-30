package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.ApiException;
import com.rodd331.crud.impl.domain.entity.UserEntity;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    public UserEntity create(UserEntity user) {
        return null;
    }

    public List<UserResponse> listAll(int page) {
        return null;
    }

    public UserEntity findById(String id) {
        return null;
    }

    public void delete(String id) {

    }

    public UserEntity update(UserEntity user, String id) {
        user.setId(id);
        return null;
    }

    public void validationEmptyList() {
            throw new ApiException(HttpStatus.NOT_FOUND, "There are no registered users");
    }

    public void validatorId(String id) {

    }
}