package com.nc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
@Controller
public class IndexController {
    @GetMapping(value= "/")
    public String index() {
        return "/index";
    }

    @GetMapping("/index")
    public String start() {
        return "/index";
    }
}
