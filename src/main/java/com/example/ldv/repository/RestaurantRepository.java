package com.example.ldv.repository;

import com.example.ldv.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface RestaurantRepository {
    boolean delete(Long id);
    Restaurant save(Restaurant restaurant);
    Iterable<Restaurant> findAll();
}
