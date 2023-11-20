package com.project.demo.repository;


import com.project.demo.model.entity.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LunchRepository extends JpaRepository<Lunch, Long> {

}