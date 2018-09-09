package com.example.ldv.repository;

import com.example.ldv.domain.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> find(Long restaurantId);
    boolean delete(Long id);
    boolean deleteAll(Long restaurantId);
    boolean save(Dish dish);
}
