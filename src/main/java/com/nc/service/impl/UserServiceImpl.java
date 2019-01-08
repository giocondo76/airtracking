package com.nc.service.impl;

import com.nc.controllers.Valid.UserDto;
import com.nc.controllers.response.EmailExistsException;
import com.nc.models.Role;
import com.nc.models.User;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
import com.nc.service.UserService;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

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
        Role userRole = roleRepository.getById(2);
        user.setRole(userRole);
        return userRepository.save(user);
    }


        private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
//        @Override
//     @Transactional
//    public int addUser(User user) {
////        user.setPassword(bcryptEncoder.encode(user.getPassword()));
////        long count = userRepository.countByEmail(user.getEmail());
////        if (count == 0) {
////            userRepository.saveAndFlush(user);
////        } else {
////            return 1;
////        }
////
////        return 0;
////    }

//    @Override
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User findById(Integer id) {
//        User user = userRepository.findById(id);
//        return user;
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        User user = userRepository.findByEmail(email);
//        return user;
//    }


}
