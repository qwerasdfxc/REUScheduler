package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "lession", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Lession {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lessionInDeportment", schema = "REUScheduler",
    joinColumns = @JoinColumn(name = "lession_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    private List<Department> departmentList;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lessionInCirriculum", schema = "REUScheduler",
            joinColumns = @JoinColumn(name = "curriculum_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    private List<Curriculum> curriculumList;
}