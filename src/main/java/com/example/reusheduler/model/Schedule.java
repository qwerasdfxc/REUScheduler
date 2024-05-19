package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table(name = "schedule", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "module")
    private String module;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "createDate1")
    private LocalDateTime createDate123;

    @Column(name = "createDate11")
    private LocalDateTime createDate111112;
}