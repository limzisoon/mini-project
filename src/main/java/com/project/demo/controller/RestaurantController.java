package com.project.demo.controller;

import com.project.demo.model.entity.Restaurant;
import com.project.demo.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
    }

    @GetMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "GET", description = "Get the full restaurant list",summary = "to get the full restaurant list")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        try {
            System.out.println("getAllRestaurants");
            List<Restaurant> restaurants = restaurantService.getRestaurants();

            if (restaurants.isEmpty()) {
                System.out.println("no restaurants found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("restaurants size: " + restaurants.size());

            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception"+e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurants/{cd}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "GET", description = "Get the restaurant information by restaurant code",summary = "Get the restaurant information by restaurant code")
    public ResponseEntity<Restaurant> getRestaurantByCd(@PathVariable("cd") String cd) {
        try {
            System.out.println("getRestaurantByCd");
            Optional<Restaurant> restaurant = restaurantService.getRestaurantByCd(cd);

            if (restaurant.isPresent()) {
                System.out.println("restaurant : "+restaurant.toString());
                return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
            } else {
                System.out.println("no restaurant found with code: "+cd);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}