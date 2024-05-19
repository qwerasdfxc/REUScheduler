package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Table(name = "lessionInSchedule", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class LessionInSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "studyDay")
    private LocalDate studyDate;



}