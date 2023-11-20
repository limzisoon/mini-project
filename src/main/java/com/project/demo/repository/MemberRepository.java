package com.project.demo.repository;


import com.project.demo.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByLunchId(Long lunchId);
}