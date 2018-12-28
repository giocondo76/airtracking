package com.nc.service;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface IService<T> {

    List<T> getAll();
    T getById(Integer id);
}
