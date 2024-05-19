package com.example.reusheduler.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "group", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column("groupNumber")
    private Long groupNumber;

    @Column("direction")
    private String direction;
}