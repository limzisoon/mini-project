package com.project.demo.service;

import com.project.demo.model.entity.Restaurant;
import com.project.demo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() throws Exception {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        restaurantRepository.findAll().forEach(restaurants::add);

        return restaurants;
    }

    public Optional<Restaurant> getRestaurantByCd(String cd) throws Exception {
        return restaurantRepository.findByCode(cd);
    }
}
