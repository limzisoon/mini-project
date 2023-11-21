package com.project.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDTO {

    private Long id;

    private String name;

    private Long lunchId;

    private String restaurantCd;

    private String restaurantName;

    private String error;

}
