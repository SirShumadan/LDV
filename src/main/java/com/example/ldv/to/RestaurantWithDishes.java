package com.example.ldv.to;

import com.example.ldv.domain.Dish;

import java.util.List;

public class RestaurantWithDishes {
    private List<Dish> dishes;
    private Long id;
    private String name;

    public RestaurantWithDishes(List<Dish> dishes, Long id, String name) {
        this.dishes = dishes;
        this.id = id;
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
