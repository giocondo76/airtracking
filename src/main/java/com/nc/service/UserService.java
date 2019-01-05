package com.nc.service;

import com.nc.models.User;
import com.nc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    int addUser(User user);

    List<User> getAll();

    User findById(Integer id);

    User findByEmail(String email);
}
