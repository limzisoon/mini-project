package com.project.demo.service;

import com.project.demo.model.entity.Member;
import com.project.demo.model.response.MemberResponseDTO;
import com.project.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public MemberResponseDTO saveMember(Member member) throws Exception {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        System.out.println(member.toString());

        memberRepository.save(member);

        member = memberRepository.getById(member.getId());

        BeanUtils.copyProperties(member, memberResponseDTO);

        return memberResponseDTO;

    }

    public void removeMember(Long id) throws Exception {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        }
    }

    public List<MemberResponseDTO> getMemberListByLunchId(Long lunchId) throws Exception {
        List<Member> memberList = memberRepository.findByLunchId(lunchId);
        List<MemberResponseDTO> memberResponseDTOList = new ArrayList<>();

        for(Member member : memberList)
        {
            MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
            BeanUtils.copyProperties(member, memberResponseDTO);
            memberResponseDTOList.add(memberResponseDTO);
        }
        return memberResponseDTOList;
    }
}
