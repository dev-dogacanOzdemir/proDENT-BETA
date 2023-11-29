package com.example.prodentv111.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/dashboard")
    public String dashboard(){
        return "login başarılı";
    }
}
