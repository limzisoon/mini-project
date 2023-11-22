package com.project.demo.model.request;

import com.project.demo.model.entity.Member;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LunchRequestDTO  implements Serializable {

    private Long id;
    private String description;
    private String createdBy;
    private List<Member> members;
}
