package com.nc.repository;

import com.nc.models.Condition;
import com.nc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository< User, Integer> {

    User findByName(String name);

    User findByEmail(String email);

    Long countByEmail(String email);

    User findById(Integer id);

    List<User> findAll();
}