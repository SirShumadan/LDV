package com.example.ldv.service.impl;

import com.example.ldv.domain.Dish;
import com.example.ldv.repository.DishRepository;
import com.example.ldv.service.DishService;
import com.example.ldv.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public void deleteAll(Long restaurantId) {
        dishRepository.deleteAll(dishRepository.findByRestaurantId(restaurantId));
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish get(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new NotFoundException("Dish " + id + " id not found."));
    }

    @Override
    public List<Dish> getAll(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}
