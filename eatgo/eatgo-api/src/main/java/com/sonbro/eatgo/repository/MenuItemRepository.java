package com.sonbro.eatgo.repository;

import com.sonbro.eatgo.domain.MenuItem;
import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long restaurantId);
}
