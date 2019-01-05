package com.nc.repository;

import com.nc.models.Standart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandartRepository extends JpaRepository<Standart, Integer> {

    Standart getById(Integer id);
}
