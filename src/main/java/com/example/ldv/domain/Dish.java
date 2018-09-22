package com.example.ldv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "price", precision = 10, scale = 2)
    @NotNull
    private double price;

    @Column(name = "restaurant_id")
    @NotNull
    private long restaurantId;

    public Dish() {
    }

    public Dish(String name, double price, long restaurantId) {
        this(null, name, price, restaurantId);
        this.name = name;
        this.price = price;
    }

    public Dish(Long id, String name, double price, long restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Dish) {
            Dish that = (Dish) obj;
            return id != null && id.equals(that.id);
        }
        return false;
    }
}
