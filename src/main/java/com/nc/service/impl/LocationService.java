package com.nc.service.impl;

import com.nc.models.Location;
import com.nc.repository.LocationRepository;
import com.nc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LocationService implements IService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location getById(Integer id) {
       return locationRepository.getById(id);
    }


}


