package com.app.rest.service;

import com.app.rest.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


// UserDetailsService is the guard that enables security
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

}
