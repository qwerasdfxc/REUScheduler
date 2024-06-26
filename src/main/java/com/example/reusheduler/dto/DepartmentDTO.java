package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Builder
@ToString
@Data
public class DepartmentDTO {

    private String name;

    private List<Long> lessions;
}
