package com.example.reusheduler.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "lessionInSchedule", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class LessionInSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column("number")
    private Long number;

    @Column("studyDay")
    private LocalDate studyDate;

}