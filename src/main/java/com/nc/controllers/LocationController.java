package com.nc.controllers;

import com.nc.models.LocType;
import com.nc.models.Location;
import com.nc.models.Standart;
import com.nc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;


    @GetMapping
    public String location(Map<String, Object> model){

        List<Location> locations = locationRepository.findAll();
        model.put("locations", locations);
        return "index";

    }

    @PostMapping
    public String add(@RequestParam Integer id, @RequestParam String name, @RequestParam LocType locType,
                      @RequestParam Standart standart, Map<String, Object> model) {
        Location location = new Location(id, name, locType, standart);

        locationRepository.save(location);

        Iterable<Location> locations = locationRepository.findAll();

        model.put("locations", locations);

        return "location";
    }
}
