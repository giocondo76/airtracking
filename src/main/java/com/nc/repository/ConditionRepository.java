package com.nc.repository;

import com.nc.models.Condition;
import com.nc.models.Location;
import com.sun.org.apache.xpath.internal.functions.FuncQname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepository extends JpaRepository< Condition, Integer> {
    Condition getById(Integer id);

    List<Condition>  findByLocationId(@Param("loc_id") Integer id);





}
