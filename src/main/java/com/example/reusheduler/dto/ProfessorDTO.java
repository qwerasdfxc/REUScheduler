package com.example.reusheduler.dto;

import com.example.reusheduler.model.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
public class ProfessorDTO {

    private Long id;

    private String professorName;

    private Long workHours;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Department department;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long departmentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String departmentName;

}
