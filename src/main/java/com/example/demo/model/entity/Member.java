package com.example.demo.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Setter
@Getter
@ToString
@Data
@Entity
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

    public Member() {

    }
}