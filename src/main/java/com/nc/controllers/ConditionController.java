package com.nc.controllers;

import com.nc.models.Condition;
import com.nc.models.Location;
import com.nc.repository.ConditionRepository;
import com.nc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ConditionController {

    @Autowired
    private ConditionRepository conditionRepository;

    private Location location;

//    @Autowired
//    private ChangeRepository changeRepository;



    @RequestMapping(value ="/condition/{id}", method = RequestMethod.GET)
    public String condition( Map<String, Object> model, @PathVariable Integer id){

        List<Condition> conditions = conditionRepository.findByLocationId(id);
        model.put("conditions", conditions);
        return "condition";
    }

//
//    @PostMapping("/condition")
//    public String saveChange(@RequestParam  Integer temp, @RequestParam Integer hum, @RequestParam Integer co2,
//                             @RequestParam Location location, Map<String, Object> model)
//    {
////        Change change = new Change(temp,hum,co2,location);
////        changeRepository.save(change);
//        return "condition";
//    }


}
