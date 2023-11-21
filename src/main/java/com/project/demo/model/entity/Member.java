package com.project.demo.model.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lunch_id")
    private long lunchId;

    @Column(name = "restaurant_cd")
    private String restaurantCd;

}