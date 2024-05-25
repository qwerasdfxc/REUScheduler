package com.example.reusheduler.dto;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString
@Data
public class SchedDTO {

    private Long id;

    private String module;

    private LocalDate createDate;

    private String groupName;

    private Long number;
}
