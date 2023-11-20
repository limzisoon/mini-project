package com.example.demo.repository;


import com.example.demo.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByCode(String code);
}