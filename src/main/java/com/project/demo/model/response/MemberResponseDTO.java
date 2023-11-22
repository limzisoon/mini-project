package com.project.demo.model.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberResponseDTO {

    private Long id;

    private String name;

    private Long lunchId;

    private String restaurantCd;

    private String restaurantName;

    private String restaurantAddr;

    private String error;

}
