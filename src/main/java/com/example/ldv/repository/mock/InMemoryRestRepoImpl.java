package com.example.ldv.repository.mock;

import com.example.ldv.domain.Restaurant;
import com.example.ldv.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryRestRepoImpl implements RestaurantRepository{
    private List<Restaurant> data;
    {
        data = new ArrayList<>();
        data.add(new Restaurant(1L, "restaurant1"));
        data.add(new Restaurant(2L, "restaurant2"));
        data.add(new Restaurant(3L, "restaurant3"));
    }

    public List<Restaurant> findAll() {
        return data;
    }

    public boolean save(Restaurant restaurant) {
        data.add(restaurant);
        return data.contains(restaurant);
    }

    public boolean delete(Long id) {
        for(int i = 0; i < data.size(); i ++){
            if(data.get(i).getId() == id){
                data.remove(i);
                return true;
            }
        }
        return false;
    }
}
