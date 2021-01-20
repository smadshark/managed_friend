package com.sonbro.eatgo.interfaces;

import com.sonbro.eatgo.domain.MenuItem;
import com.sonbro.eatgo.domain.Restaurant;
import com.sonbro.eatgo.repository.MenuItemRepository;
import com.sonbro.eatgo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return restaurant;
    }
}
