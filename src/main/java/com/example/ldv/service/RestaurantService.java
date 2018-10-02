package com.example.ldv.service;

import com.example.ldv.domain.Restaurant;
import com.example.ldv.to.RestaurantWithDishes;

import java.util.List;

public interface RestaurantService {
    List<RestaurantWithDishes> restaurantsWithDishes();
    RestaurantWithDishes getRestaurantWithDishes(Long id);
    Restaurant save(Restaurant restaurant);
    Restaurant get(Long id);
    void delete(Long id);
    List<Restaurant> getAll();
}
