package com.timwenzeltech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping(path = "/")
    public String helloAdminController() {
        return "Admin access level";
    }
}
