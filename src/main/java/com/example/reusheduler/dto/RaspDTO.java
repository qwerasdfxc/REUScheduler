package com.example.reusheduler.dto;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString
@Data
public class RaspDTO {

    private Long groupId;

    private Long module;

    private LocalDate startDate;

    private LocalDate endDate;
}
