package com.example.ldv.repository;

import com.example.ldv.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getRestaurants();
    void addRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id);
}
