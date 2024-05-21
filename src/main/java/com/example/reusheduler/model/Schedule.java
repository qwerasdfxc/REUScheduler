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
@Entity
@ToString

public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "module")
    private String module;

    @Column(name = "createDate")
    private LocalDateTime createDate;
}