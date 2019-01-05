package com.nc.service.impl;

import com.nc.models.User;
import com.nc.repository.UserRepository;
import com.nc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public int addUser(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        long count = userRepository.countByEmail(user.getEmail());
        if (count == 0) {
            userRepository.saveAndFlush(user);
        } else {
            return 1;
        }

        return 0;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }


}
