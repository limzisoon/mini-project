package com.project.demo.controller;

import com.project.demo.constant.CommonConstant;
import com.project.demo.model.entity.Restaurant;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.service.LunchService;
import lombok.SneakyThrows;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)

class LunchControllerTest {

    @InjectMocks
    private LunchController lunchController;

    @Mock
    private LunchService lunchService;

    List<Restaurant> list = new ArrayList<>();

    @BeforeEach
    void setUp(){
        lunchController = new LunchController(lunchService);
    }

    @SneakyThrows
    @DisplayName("whenInitLunch_thenSuccess")
    @Test
    void whenInitLunch_thenSuccess() {

        when(lunchService.createLunch(any())).thenReturn(LunchResponseDTO.builder().id(Long.parseLong("1")).status(CommonConstant.SESSION_START).build());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lunchController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/init-lunch")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("whenInitLunch_Exception")
    @SneakyThrows
    void whenInitLunch_Exception() {

        when(lunchService.createLunch(any())).thenThrow(new Exception());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lunchController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/init-lunch")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is5xxServerError()).andReturn();
    }
}