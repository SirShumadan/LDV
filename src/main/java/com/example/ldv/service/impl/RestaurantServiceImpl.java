package com.example.ldv.service.impl;

import com.example.ldv.repository.DishRepository;
import com.example.ldv.repository.RestaurantRepository;
import com.example.ldv.service.RestaurantService;
import com.example.ldv.to.RestaurantWithDishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    private DishRepository dishRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

//такое к-во запросов насилует базу данных. лучше сразу выгружать все в рестораны. или кэшировние
    public List<RestaurantWithDishes> restaurantsWithDishes() {
        return restaurantRepository
                .findAll()
                .stream()
                .map(r -> new RestaurantWithDishes(dishRepository.findByRestaurantId(r.getId()), r.getId(), r.getName()))
                .collect(Collectors.toList());
    }
}
