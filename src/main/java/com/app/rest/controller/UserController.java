package com.app.rest.controller;

import com.app.rest.model.UserDetailsRequestModel;
import com.app.rest.response.UserRest;
import com.app.rest.service.UserService;
import com.app.rest.shared.UserDto;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "Get User was created";
    }

    //    UserDetailsRequestModel convert JSON into a JavaObject;
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        // This is what we are going to return
        UserRest returnValue = new UserRest();
        // Create a new user
        UserDto userDto = new UserDto();
        // Serialize and copy the payload into a userDto
        BeanUtils.copyProperties(userDetails, userDto);
        // Save it in the DB
        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete user was called";
    }

}
