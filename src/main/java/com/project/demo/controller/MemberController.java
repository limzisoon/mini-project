package com.project.demo.controller;

import com.project.demo.constant.CommonConstant;
import com.project.demo.exception.BusinessException;
import com.project.demo.model.entity.Lunch;
import com.project.demo.model.entity.Member;
import com.project.demo.model.request.MemberRequestDTO;
import com.project.demo.model.response.LunchResponseDTO;
import com.project.demo.model.response.MemberResponseDTO;
import com.project.demo.service.LunchService;
import com.project.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    LunchService lunchService;

    @PostMapping(value = "/add-member", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "POST", description = "add new member",summary = "add new member and user to select restaurant")
    public ResponseEntity<MemberResponseDTO> addMember(@RequestBody MemberRequestDTO memberRequestDTO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        try {
            Member member = Member.builder().build();
            member.setName(memberRequestDTO.getName());
            member.setLunchId(memberRequestDTO.getLunchId());
            member.setRestaurantCd(memberRequestDTO.getRestaurantCd());

            Lunch lunch = lunchService.getLunch(memberRequestDTO.getLunchId());
            //4b.) validate if lunch session is end, unable add member
            if(CommonConstant.SESSION_END.equals(lunch.getStatus()))
            {
                throw new BusinessException(CommonConstant.BUSINESS_ERROR_1);
            }

            memberResponseDTO = memberService.saveMember(member);

            return new ResponseEntity<>(memberResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            memberResponseDTO.setError(e.getMessage());
            return new ResponseEntity<>(memberResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/remove-member/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "POST", description = "remove member",summary = "to remove member from lunch")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            memberService.removeMember(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/members/{lunchId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(method = "GET", description = "get member list and restaurants from lunch",summary = "All users in the session are able to see restaurants that others have submitted.")
    public ResponseEntity<List<MemberResponseDTO>> getMemberListByRestaurantId(@PathVariable("lunchId") Long lunchId) {
        try {
            List<MemberResponseDTO> memberList = memberService.getMemberListByLunchId(lunchId);

            if (memberList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("size" + memberList.size());

            return new ResponseEntity<>(memberList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}