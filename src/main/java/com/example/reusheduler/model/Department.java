package com.example.reusheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Table(name = "department", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
    private List<Professor> professorList;

    @ManyToMany(mappedBy = "departmentList", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lession> lessionList;
}
