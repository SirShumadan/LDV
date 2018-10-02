package com.example.ldv.service;

import com.example.ldv.domain.Dish;

import java.util.List;

public interface DishService {
    void delete(Long id);
    void deleteAll(Long restaurantId);
    Dish save(Dish dish);
    Dish get(Long id);
    List<Dish> getAll(Long restaurantId);
}
