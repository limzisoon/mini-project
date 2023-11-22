package com.project.demo.controller;

import com.project.demo.constant.CommonConstant;
import com.project.demo.model.entity.Lunch;
import com.project.demo.model.entity.Member;
import com.project.demo.model.entity.Restaurant;
import com.project.demo.model.request.LunchRequestDTO;
import com.project.demo.model.request.MemberRequestDTO;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.service.LunchService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
public class LunchController {

    @Autowired
    LunchService lunchService;

    public LunchController(LunchService lunchService) {
    }


    @PostMapping(value = "/init-lunch", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "POST", description = "initial lunch session",summary = "to initial lunch session")
    public ResponseEntity<LunchResponseDTO> initLunch(@RequestBody LunchRequestDTO lunchRequestDTO) {
        try {
            Lunch lunch = Lunch.builder().build();
            lunch.setStatus(CommonConstant.SESSION_START);
            lunch.setDescription(lunchRequestDTO.getDescription());
            lunch.setCreatedTime(LocalDateTime.now());
            lunch.setLastUpdatedTime(LocalDateTime.now());
            lunch.setCreatedBy(lunchRequestDTO.getCreatedBy());

            LunchResponseDTO lunchResponseDTO = lunchService.createLunch(lunch);
            System.out.println("lunch created :"+lunchResponseDTO.toString());

            return new ResponseEntity<>(lunchResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/end-lunch", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "POST", description = "End lunch session",summary = "to End lunch session")
    public ResponseEntity<LunchResponseDTO> endLunch(@RequestBody LunchRequestDTO lunchRequestDTO) {
        LunchResponseDTO lunchResponseDTO = new LunchResponseDTO();
        try {
            Lunch lunch = lunchService.getLunch(lunchRequestDTO.getId());
            System.out.println("load lunch: "+lunch.toString());

            lunch.setStatus(CommonConstant.SESSION_END);
            lunch.setDescription(lunchRequestDTO.getDescription());
            lunch.setLastUpdatedTime(LocalDateTime.now());

            //4a.) random picked Restaurant from members
            List memberList = lunchRequestDTO.getMembers();
            if(memberList!=null&&!memberList.isEmpty())
            {
                for (int i = 0; i < memberList.size(); i++) {
                    int index = (int) (Math.random() * memberList.size());
                    MemberRequestDTO member = (MemberRequestDTO) memberList.get(index);
                    lunch.setPickedRestaurantCd(member.getRestaurantCd());
                    System.out.println("PickedRestaurantCd :"+member.getRestaurantCd());
                }
            }

            lunchResponseDTO = lunchService.updateLunch(lunch);
            System.out.println("lunch updated :"+lunchResponseDTO.toString());

            return new ResponseEntity<>(lunchResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(lunchResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lunch/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "GET", description = "Get the lunch information by lunch id",summary = "Get the lunch information by lunch id")
    public ResponseEntity<LunchResponseDTO> getLunchWithMemberById(@PathVariable("id") Long id) {
        try {
            System.out.println("getLunchById");
            LunchResponseDTO lunchResponseDTO = lunchService.getLunchWithMemberById(id);

            System.out.println("lunchResponseDTO : "+lunchResponseDTO.toString());
            return new ResponseEntity<>(lunchResponseDTO, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}