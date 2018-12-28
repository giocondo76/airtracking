package com.nc.repository;

import com.nc.models.LocType;
import com.nc.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocTypeRepository extends JpaRepository< Location, Integer> {

    LocType getById(Integer id);
}
