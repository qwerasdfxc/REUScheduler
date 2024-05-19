package com.example.reusheduler.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "department", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column("name")
    private String name;


//    @OneToMany()
//    @JoinColumn(name = "user_id")
//    private List<Professor> professorList;
}
