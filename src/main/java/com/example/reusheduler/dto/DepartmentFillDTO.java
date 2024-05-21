package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Builder
@ToString
@Data
public class DepartmentFillDTO {

    private String mane;

    private List<Long> lessions;
}
