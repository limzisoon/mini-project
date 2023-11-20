package com.project.demo.service;

import com.project.demo.model.entity.Lunch;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.repository.LunchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LunchService {

    @Autowired
    LunchRepository lunchRepository;

    public LunchResponseDTO createLunch(Lunch lunch) throws Exception
    {
            LunchResponseDTO lunchResponseDTO = new LunchResponseDTO();

            lunchRepository.save(lunch);

            lunch = getLunch(lunch.getId());

            BeanUtils.copyProperties(lunch, lunchResponseDTO);

            return lunchResponseDTO;

    }

    public LunchResponseDTO updateLunch(Lunch lunch) throws Exception
    {
        LunchResponseDTO lunchResponseDTO = new LunchResponseDTO();

        lunchRepository.save(lunch);

        lunch = getLunch(lunch.getId());

        BeanUtils.copyProperties(lunch, lunchResponseDTO);

        return lunchResponseDTO;

    }

    public Lunch getLunch(Long id) throws Exception
    {
        return lunchRepository.getById(id);
    }
}
