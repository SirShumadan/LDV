package com.example.ldv.domain;

import java.util.List;

public class Restaurant {
    private long id;
    private String name;
    private List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Restaurant(int id, String name, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.dishes = dishes;
    }

    public Restaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Restaurant: ").append(name).append("\n");
        dishes.forEach(d -> str.append("\t").append("Dish: ").append(d.getName()).append("::").append(d.getPrice()).append("\n"));
        return str.toString();
    }
}
