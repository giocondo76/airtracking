package com.nc.controllers;

import com.nc.controllers.response.EmailExistsException;
import com.nc.models.User;
import com.nc.controllers.Valid.UserDto;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
import com.nc.service.UserService;
import com.nc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.nc.service.UserService.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserServiceImpl service;

//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto accountDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("index", "user", accountDto);
        }
    }
    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
//    @PostMapping("/registration")
//    public String registration(Map<String, Object> model) {
//
//        User user = new User();
//        user.setName(user.getName());
//        user.setName(user.getName());
//        user.setPassword(user.getPassword());
//        user.setRole(roleRepository.findOne(2));
//
//        User userFromDb = userRepository.findByName(user.getName());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        userRepository.save(user);
//
//        return "redirect:/index";
//    }


}
