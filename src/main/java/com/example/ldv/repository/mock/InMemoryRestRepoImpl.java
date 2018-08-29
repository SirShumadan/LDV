package com.example.ldv.repository.mock;

import com.example.ldv.domain.Dish;
import com.example.ldv.domain.Restaurant;
import com.example.ldv.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class InMemoryRestRepoImpl implements RestaurantRepository {
    private List<Restaurant> data;
    {
        data = new ArrayList<Restaurant>();
        data.add(new Restaurant(1, "restaurant1", Arrays.asList(
                new Dish("name1", 1.0),
                new Dish("name2", 2.0),
                new Dish("name3", 3.0))));
        data.add(new Restaurant(2, "restaurant2", Arrays.asList(
                new Dish("name1", 1.0),
                new Dish("name2", 2.0),
                new Dish("name3", 3.0))));
        data.add(new Restaurant(3, "restaurant3", Arrays.asList(
                new Dish("name1", 1.0),
                new Dish("name2", 2.0),
                new Dish("name3", 3.0))));
    }

    public List<Restaurant> getRestaurants() {
        return data;
    }

    public void addRestaurant(Restaurant restaurant) {
        data.add(restaurant);
    }

    public void deleteRestaurant(int id) {
        for(int i = 0; i < data.size(); i ++){
            if(data.get(i).getId() == id){
                data.remove(i);
                break;
            }
        }
    }
}
