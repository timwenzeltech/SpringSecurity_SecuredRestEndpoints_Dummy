package com.timwenzeltech.controller;

import com.timwenzeltech.models.ApplicationUser;
import com.timwenzeltech.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserApiController
 */
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserApiController {

    @Autowired
    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<ApplicationUser> getUser(@PathVariable Integer userId, Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        // WARN: Janky behaviour due to classifying the UserId as Integer before:
        Long authenticatedUserId = jwt.getClaim("user_id");
        Integer authId = authenticatedUserId.intValue();

        System.out.println("Authenticated User ID : " + authenticatedUserId);
        System.out.println("Requested User ID : " + userId);

        if (!authId.equals(userId)) {
            System.out.println("User ID mismatch: authenticatedUserId= " + authenticatedUserId + "requestedUserId= "
                    + userId);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        ApplicationUser user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
