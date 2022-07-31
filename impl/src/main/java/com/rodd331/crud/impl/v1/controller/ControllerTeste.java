package com.rodd331.crud.impl.v1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/")
@RestController
@AllArgsConstructor
public class ControllerTeste {

    @GetMapping
    public String listUsers() {
        return "Teste funcionou2!!!";
    }
}
