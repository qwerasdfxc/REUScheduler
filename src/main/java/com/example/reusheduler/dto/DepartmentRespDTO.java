package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
@Data
public class DepartmentRespDTO {

    private Long id;

    private String name;

    private List<String> lessions;
}
