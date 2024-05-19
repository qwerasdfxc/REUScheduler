package com.example.reusheduler.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "lession", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Lession {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column("name")
    private String name;
}