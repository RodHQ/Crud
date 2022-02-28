package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.domain.repository.UserRepository;
import com.rodd331.crud.stubs.UserStub;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.Optional;

import static com.rodd331.crud.stubs.UserStub.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void createUser() {
        when(userRepository.save(any())).thenReturn(UserStub.generationUserEntity());
        userService.create(generationUserEntity());
        verify(userRepository).save(generationUserEntity());
    }

    @Test
    public void listAllUsersReturn() {
        expectedException.expectMessage("Ivalid page");
        when(userRepository.findAll(PageRequest.of(3, 5))).thenReturn(generationPageUserEntity());
        userService.listAll(3);
    }

    @Test
    public void validationEmptyList() {
        expectedException.expectMessage("There are no registered users");
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        userService.validationEmptyList();
    }

    @Test
    public void validatorUserId() {
        expectedException.expectMessage("User not found");
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        userService.validatorId("someid");
    }

    @Test
    public void validatorUserId_2() {
        when(userRepository.findById(any())).thenReturn(Optional.of(generationUserEntity()));
        userService.validatorId("someid");
        verify(userRepository).findById("someid");
    }

    @Test
    public void userFindById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserStub.generationUserEntity()));
        userService.findById("someid");
        verify(userRepository).findById("someid");
    }

    @Test
    public void deleteUserById() {
        userService.delete("someid");
        verify(userRepository).deleteById("someid");
    }

    @Test
    public void userUpdate() {
        when(userRepository.save(any())).thenReturn(generationUserEntity());
        userService.update(generationUserEntity(), "someid");
        verify(userRepository).save(generationUserEntity());
    }
}