package com.rodd331.crud.impl.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodd331.crud.impl.domain.repository.UserRepository;
import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.impl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.rodd331.crud.stubs.UserStub.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ApiController.class)
@ContextConfiguration(classes = {ApiController.class,
        UserFacade.class,
        UserFacade.class,
        UserService.class})
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findById_ReturnCode_OK() throws Exception {
        given(userRepository.findById("someid")).willReturn(Optional.of(generationUserEntity2()));
        this.mockMvc.perform(get("/crud/v1/user/someid"))
                .andExpect(status().isOk());
    }

    @Test
    public void allUsers_ReturnCode_OK() throws Exception {
        given(userRepository.findAll()).willReturn(generationListUserEntity());
        when(userRepository.findAll(PageRequest.of(0, 5))).thenReturn(generationPageUserEntity());
        this.mockMvc.perform(get("/crud/v1/user/page/0")).andExpect(status().isOk());
    }


    @Test
    public void createUser_ReturnCode_Created() throws Exception {
        given(userRepository.save(any())).willReturn(generationUserEntity());
        this.mockMvc.perform(post("/crud/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(generationUserEntity())))
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteFindById_ReturnCode_Ok() throws Exception {
        given(userRepository.findById("someid")).willReturn(Optional.of(generationUserEntity()));
        this.mockMvc.perform(delete("/crud/v1/user/someid")).andExpect(status().isNoContent());
    }


    @Test
    public void updateUser_ReturnCode_OK() throws Exception {
        given(userRepository.findById("someid")).willReturn(Optional.of(generationUserEntity()));
        given(userRepository.save(any())).willReturn(generationUserEntity());
        this.mockMvc.perform(put("/crud/v1/user/someid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(generationUserEntity()))).andExpect(status().isOk());
    }
}