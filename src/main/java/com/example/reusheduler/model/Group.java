package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "group", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "groupNumber")
    private Long groupNumber;

    @Column(name = "direction")
    private String direction;
}