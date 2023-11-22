package com.project.demo.service;

import com.project.demo.model.entity.Lunch;
import com.project.demo.model.entity.Member;
import com.project.demo.model.entity.Restaurant;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.model.response.MemberResponseDTO;
import com.project.demo.repository.LunchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LunchService {

    @Autowired
    LunchRepository lunchRepository;
    @Autowired
    MemberService memberService;

    public LunchResponseDTO createLunch(Lunch lunch) throws Exception
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

    public LunchResponseDTO updateLunch(Lunch lunch) throws Exception
    {
        LunchResponseDTO lunchResponseDTO = new LunchResponseDTO();

        lunchRepository.save(lunch);

        lunch = getLunch(lunch.getId());

        BeanUtils.copyProperties(lunch, lunchResponseDTO);

        return lunchResponseDTO;

    }

    public LunchResponseDTO getLunchWithMemberById(Long lunchId) throws Exception {

        LunchResponseDTO lunchResponseDTO = new LunchResponseDTO();
        Lunch lunch = getLunch(lunchId);
        BeanUtils.copyProperties(lunch, lunchResponseDTO);

        List<MemberResponseDTO>  memberList = memberService.getMemberListByLunchId(lunch.getId());

        lunchResponseDTO.setMemberResponseDTOList(memberList);

        return lunchResponseDTO;
    }
}
