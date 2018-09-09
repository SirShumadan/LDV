package com.example.ldv.repository;

import com.example.ldv.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    boolean delete(Long id);
    boolean save(Restaurant restaurant);
    List<Restaurant> findAll();
    Restaurant find(Long id);
}
