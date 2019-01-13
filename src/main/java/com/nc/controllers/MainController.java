package com.nc.controllers;

import com.nc.models.LocType;
import com.nc.models.Location;
import com.nc.models.Standart;
import com.nc.repository.LocTypeRepository;
import com.nc.repository.LocationRepository;
import com.nc.repository.StandartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocTypeRepository locTypeRepository;

    @Autowired
    private StandartRepository standartRepository;

    @GetMapping
    public String index(Map<String, Object> model){

        List<Location> locations = locationRepository.findAll();
        model.put("locations", locations);
        return "index";

    }

//    @RequestMapping(value ="/index", method = RequestMethod.POST)
//    public String add(@RequestParam Integer id, @RequestParam String name, @RequestParam LocType locType,
//                      @RequestParam Standart standart, Map<String, Object> model) {
//        Location location = new Location(id, name, locType, standart);
//
//        locationRepository.save(location);
//
//        Iterable<Location> locations = locationRepository.findAll();
//
//        model.put("locations", locations);
//
//        return "index";
//    }
}
