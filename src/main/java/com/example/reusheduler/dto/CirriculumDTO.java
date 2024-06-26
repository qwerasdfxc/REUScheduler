package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
@Data
public class CirriculumDTO {

    private String groupNumber;

    private Long groupId;


    private Long module;

    private List<LessionForCirr> lessons;

}


