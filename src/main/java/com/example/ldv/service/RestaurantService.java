package com.example.ldv.service;

import com.example.ldv.to.RestaurantWithDishes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RestaurantService {
    List<RestaurantWithDishes> restaurantsWithDishes();
}
