package com.nc.controllers;

import com.nc.models.Location;
import com.nc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public String index(Map<String, Object> model){

        List<Location> locations = locationRepository.findAll();
        model.put("locations", locations);
        return "index";

    }
}
