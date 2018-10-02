package com.example.ldv.service.impl;

import com.example.ldv.domain.Restaurant;
import com.example.ldv.repository.RestaurantRepository;
import com.example.ldv.service.DishService;
import com.example.ldv.service.RestaurantService;
import com.example.ldv.to.RestaurantWithDishes;
import com.example.ldv.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    private DishService dishService;


    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishService dishService) {
        this.restaurantRepository = restaurantRepository;
        this.dishService = dishService;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
        dishService.deleteAll(restaurantId);
    }

    @Override
    public Restaurant get(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new NotFoundException("restaurant is not found"));
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public RestaurantWithDishes getRestaurantWithDishes(Long restaurantId) {
        Restaurant r = get(restaurantId);
        return new RestaurantWithDishes(dishService.getAll(restaurantId), r.getId(), r.getName());
    }

    @Override
    public List<RestaurantWithDishes> restaurantsWithDishes() {
        return getAll().stream()
                .map(r -> new RestaurantWithDishes(dishService.getAll(r.getId()), r.getId(), r.getName()))
                .collect(Collectors.toList());
    }
}
