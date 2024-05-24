package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "professor", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String professorName;

    @Column(name = "workHours")
    private Long workHours;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
}