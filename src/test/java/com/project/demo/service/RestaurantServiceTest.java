package com.project.demo.service;

import com.project.demo.model.entity.Restaurant;
import com.project.demo.repository.RestaurantRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;



public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepository restaurantRepository;



    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    @SneakyThrows
    public void When_GetRestaurants_To_Success(){
        Restaurant restaurant = Restaurant.builder()
                .id(Long.parseLong("1"))
                .code("name")
                .name("desc")
                .address("address")
                .build();
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant);
        when(restaurantRepository.findAll()).thenReturn(restaurantList);

        List<Restaurant> restaurantResultList = restaurantService.getRestaurants();
        assertNotNull(restaurantResultList);

        assertEquals(restaurant.getCode(),restaurantResultList.get(0).getCode());
    }
}
