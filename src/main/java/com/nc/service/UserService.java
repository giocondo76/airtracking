package com.nc.service;

import com.nc.controllers.Valid.UserDto;
import com.nc.controllers.response.EmailExistsException;
import com.nc.models.User;
import com.nc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

        User registerNewUserAccount(UserDto accountDto)
                throws EmailExistsException;

}
