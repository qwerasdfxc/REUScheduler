package com.example.reusheduler.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Builder
@ToString
@Data
public class LessionForCirr {
    private String lessionName;

    private Long lessonId;

    private Long hours;
}