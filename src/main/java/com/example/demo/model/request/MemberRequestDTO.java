package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDTO {

    private Long id;
    private String name;
    private Long lunchId;
    private String restaurantCd;
}
