package com.nc.service.impl;

import com.nc.controllers.response.EmailExistsException;
import com.nc.controllers.valid.UserDto;
import com.nc.models.Role;
import com.nc.models.User;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
import com.nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  accountDto.getEmail());
        }
        User user = new User();
        user.setName(accountDto.getName());
        user.setName(accountDto.getName());
        user.setPassword(bcryptEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRoles(Collections.singleton(roleRepository.getById(2)));
        return userRepository.save(user);
    }


    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
