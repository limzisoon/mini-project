package com.project.demo.service;

import com.project.demo.model.entity.Lunch;
import com.project.demo.model.entity.Member;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.repository.LunchRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LunchServiceTest {

    @InjectMocks
    private LunchService lunchService;
    @Mock
    private LunchRepository lunchRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    @SneakyThrows
    public void When_CreateLunch_To_Success(){
        Lunch lunch = Lunch.builder()
                .id(Long.parseLong("1"))
                .createdBy("jack")
                .lastUpdatedTime(LocalDateTime.now())
                .createdTime(LocalDateTime.now())
                .description("Friday Lunch")
                .status("END")
                .pickedRestaurantCd("R001")
                .build();
        when(lunchRepository.save(lunch)).thenReturn(mock(Lunch.class));
        when(lunchRepository.getById(lunch.getId())).thenReturn(lunch);

        LunchResponseDTO lunchResponseDTO = lunchService.createLunch(lunch);
        assertEquals(lunchResponseDTO.getDescription(),lunch.getDescription());
    }

    @Test()
    @SneakyThrows
    public void When_updateLunch_To_Success(){
        Lunch lunch = Lunch.builder()
                .id(Long.parseLong("1"))
                .createdBy("jack")
                .lastUpdatedTime(LocalDateTime.now())
                .createdTime(LocalDateTime.now())
                .description("Friday Lunch")
                .status("END")
                .pickedRestaurantCd("R001")
                .build();
        when(lunchRepository.save(lunch)).thenReturn(mock(Lunch.class));
        when(lunchRepository.getById(lunch.getId())).thenReturn(lunch);

        LunchResponseDTO lunchResponseDTO = lunchService.updateLunch(lunch);
        assertEquals(lunchResponseDTO.getDescription(),lunch.getDescription());
    }

    @Test()
    @SneakyThrows
    public void When_getLunch_To_Success(){
        Lunch lunch = Lunch.builder()
                .id(Long.parseLong("1"))
                .createdBy("jack")
                .lastUpdatedTime(LocalDateTime.now())
                .createdTime(LocalDateTime.now())
                .description("Friday Lunch")
                .status("END")
                .pickedRestaurantCd("R001")
                .build();
        when(lunchRepository.getById(lunch.getId())).thenReturn(lunch);

        Lunch lunchResult = lunchService.getLunch(Long.parseLong("1"));
        assertEquals(lunchResult.getDescription(),lunch.getDescription());
    }
}
