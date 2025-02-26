package com.timwenzeltech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin("*")
public class UserController {

    @GetMapping(path = "/")
    public String helloUserController() {
        return "User access level";
    }
}
