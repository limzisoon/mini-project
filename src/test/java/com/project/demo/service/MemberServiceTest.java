package com.project.demo.service;

import com.project.demo.model.entity.Member;
import com.project.demo.model.response.MemberResponseDTO;
import com.project.demo.repository.MemberRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;



    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    @SneakyThrows
    public void When_SaveMember_To_Success(){
        Member member = Member.builder()
                .id(Long.parseLong("1"))
                .lunchId(Long.parseLong("1"))
                .restaurantCd("R001")
                .build();
        when(memberRepository.save(member)).thenReturn(mock(Member.class));
        when(memberRepository.getById(member.getId())).thenReturn(member);

        MemberResponseDTO memberResponseDTO  = memberService.saveMember(member);
        assertNotNull(memberResponseDTO);

        assertEquals(memberResponseDTO.getRestaurantCd(),member.getRestaurantCd());
    }
}
