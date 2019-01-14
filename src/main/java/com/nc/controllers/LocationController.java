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
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocTypeRepository locTypeRepository;

    @Autowired
    private StandartRepository standartRepository;

    @GetMapping("/location")
    public String index(Map<String, Object> model){

        List<Location> locations = locationRepository.findAll();
        model.put("locations", locations);
        return "location";

    }

//    @RequestMapping(value ="/index", method = RequestMethod.GET)
//    public String showLocationForm(Model model){
//        List<LocType> locTypes = locTypeRepository.findAll();
//        model.addAttribute("locTypes", locTypes);
//
//        List<Standart> standarts = standartRepository.findAll();
//        model.addAttribute("standarts", standarts);
//
//        return "index";
//    }
//    @RequestMapping(value ="/index", method = RequestMethod.POST)
//    public String addLocation(@RequestParam String name, Model model) {
//
//        Location location = new Location();
//
//        location.setName(name);
////        location.setLocType(locType);
////        location.setStandart(standart);
//        locationRepository.save(location);
//
//        Iterable<Location> locations = locationRepository.findAll();
//
//        model.addAttribute("locations", locations);
//        return "index";
//    }
//        Iterable<LocType> locTypes=locTypeRepository.findAll();
//        model.put("locTypes", locTypes);
//
//        Location location = new Location();
//
//        location.setName(name);
//        location.setLocType(locType);
//        location.setStandart(standart);
//        locationRepository.save(location);
//
//        Iterable<Location> locations = locationRepository.findAll();
//
//        model.put("locations", locations);

//        return "index";
    }

