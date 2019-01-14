package com.nc.service;

import com.nc.controllers.valid.UserDto;
import com.nc.controllers.response.EmailExistsException;
import com.nc.models.User;
import com.nc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;

}