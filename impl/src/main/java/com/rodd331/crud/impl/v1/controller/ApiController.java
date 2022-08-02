package com.rodd331.crud.impl.v1.controller;

import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.impl.handler.ExceptionResponse;
import com.rodd331.crud.impl.v1.dto.request.UserRequest;
import com.rodd331.crud.impl.v1.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/crud/v1")
@RestController
@AllArgsConstructor
public class ApiController {

    private final UserFacade userFacade;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest user) {
        return userFacade.create(user);
    }

    @GetMapping("/")
    public String listUsers() {
        return "Teste funcionou!!!";
    }

    @GetMapping("/user/{id}")
    public UserResponse searchForId(@PathVariable String id) {
        return userFacade.findById(id);
    }

    @PutMapping("/user/{id}")
    public @Valid UserResponse update(@Valid @RequestBody UserRequest user, @PathVariable String id) {
        return userFacade.update(user, id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        userFacade.delete(id);
    }
}