package com.app.rest.service.impl;

import com.app.rest.UserRepository;
import com.app.rest.io.UserEntity;
import com.app.rest.service.UserService;
import com.app.rest.shared.UserDto;
import com.app.rest.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        // Query the database and check id there is already an email
        UserEntity usersEmail = userRepository.findByEmail(user.getEmail());
        if (usersEmail != null) throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword("Test");
        userEntity.setUserId(publicUserId);
        userEntity.setGetEmailVerificationStatus(false);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
