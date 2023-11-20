package com.project.demo.controller;

import com.project.demo.model.entity.Restaurant;
import com.project.demo.service.RestaurantService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)

class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantService restaurantService;

    List<Restaurant> list = new ArrayList<>();

    @BeforeEach
    void setUp(){
        restaurantController = new RestaurantController(restaurantService);
        list.add(Restaurant.builder().id(1).name("R001").code("Kopitiam").address("108 Punggol Fld, #01-01, 820108 Singapore").build());
    }

    @SneakyThrows
    @DisplayName("whenGetAllRestaurants_thenSuccess")
    @Test
    void whenGetAllRestaurants_thenSuccess() {

        when(restaurantService.getRestaurants()).thenReturn(list);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        Assertions.assertNotNull(list);
    }

    @Test
    @DisplayName("WhenGetAllRestaurants_Exception")
    @SneakyThrows
    void WhenGetAllRestaurants_Exception() {

        when(restaurantService.getRestaurants()).thenThrow(new Exception());
        MockMvc mvc = MockMvcBuilders.standaloneSetup(restaurantController).build();

        mvc.perform(MockMvcRequestBuilders
                .get("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent()).andReturn();
    }

    @SneakyThrows
    @DisplayName("whenGetRestaurantByCd_thenSuccess")
    @Test
    void whenGetRestaurantByCd_thenSuccess() {

        Optional<Restaurant> o  = Optional.of(Restaurant.builder().id(1).name("R001").code("Kopitiam").address("108 Punggol Fld, #01-01, 820108 Singapore").build());

        when(restaurantService.getRestaurantByCd(any())).thenReturn(o);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/restaurants/R001")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        Assertions.assertNotNull(o.get());

    }

    @Test
    @DisplayName("whenGetRestaurantByCd_Exception")
    @SneakyThrows
    void whenGetRestaurantByCd_Exception() {

        when(restaurantService.getRestaurantByCd(any())).thenThrow(new Exception());
        MockMvc mvc = MockMvcBuilders.standaloneSetup(restaurantController).build();

        mvc.perform(MockMvcRequestBuilders
                .get("/restaurants/R001")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent()).andReturn();
    }
}