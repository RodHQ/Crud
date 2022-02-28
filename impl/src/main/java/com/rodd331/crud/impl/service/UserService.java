package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.ApiException;
import com.rodd331.crud.impl.domain.entity.UserEntity;
import com.rodd331.crud.impl.domain.repository.UserRepository;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import com.rodd331.crud.impl.v1.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    public Page<UserResponse> listAll(int page) {
        Page<UserEntity> usersFound = userRepository.findAll(PageRequest.of(page, 5));
        if (page < 0 || page > usersFound.getSize() / 5) throw new ApiException(HttpStatus.BAD_REQUEST, "Ivalid page");
        return usersFound.map(UserMapper::mapToUserResponse);
    }

    public UserEntity findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserEntity update(UserEntity user, String id) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void validationEmptyList() {
        if (userRepository.findAll().isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "There are no registered users");
        }
    }

    public void validatorId(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}