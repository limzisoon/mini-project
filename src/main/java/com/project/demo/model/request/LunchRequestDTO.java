package com.project.demo.model.request;

import com.project.demo.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LunchRequestDTO  implements Serializable {

    private Long id;
    private String description;
    private String createdBy;
    private List<Member> members;
}
