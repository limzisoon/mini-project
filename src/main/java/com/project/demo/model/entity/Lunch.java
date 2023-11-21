package com.project.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
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