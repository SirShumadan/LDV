package com.example.ldv.domain;

import java.time.LocalDateTime;

public class Dish {
    private long id;
    private String name;
    private double price;
//    private LocalDateTime createdDate;

    public Dish() {
    }

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}