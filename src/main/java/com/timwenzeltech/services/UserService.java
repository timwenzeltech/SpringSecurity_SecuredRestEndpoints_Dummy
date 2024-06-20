package com.timwenzeltech.services;

import com.timwenzeltech.models.ApplicationUser;
import com.timwenzeltech.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public UserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not Found!"));

        // if (!username.equals("Tim"))
        // throw new UsernameNotFoundException("Not Tim");
        //
        // Set<Role> roles = new HashSet<>();
        // roles.add(new Role(1, "user"));
        //
        // return new ApplicationUser(1, "Tim", encoder.encode("password"), roles);

    }

    public ApplicationUser getUserById(Integer userId) throws UsernameNotFoundException {
        return (ApplicationUser) userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Id: " + userId + " not Found!"));
    }

}
