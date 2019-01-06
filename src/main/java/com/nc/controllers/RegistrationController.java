package com.nc.controllers;

import com.nc.models.User;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Map<String, Object> model) {

        User user = new User();
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        user.setRole(roleRepository.findOne(2));

        User userFromDb = userRepository.findByName(user.getName());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        userRepository.save(user);

        return "redirect:/index";
    }


}
