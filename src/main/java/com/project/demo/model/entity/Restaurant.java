package com.project.demo.model.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@Data
@Entity
@Builder
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}