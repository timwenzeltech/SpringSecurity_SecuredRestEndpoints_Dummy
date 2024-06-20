package com.timwenzeltech.dto;

import com.timwenzeltech.models.ApplicationUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LoginResponseDTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {

    private ApplicationUser user;
    private String jwt;

}
