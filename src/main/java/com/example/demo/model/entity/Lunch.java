package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@Data
@Entity
@Table(name = "Lunch")
public class Lunch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    @Column(name = "last_updated_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdatedTime;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "picked_restaurant_cd")
    private String pickedRestaurantCd;
}