package com.example.reusheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;


@Table(name = "curriculum", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Curriculum {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "module")
    private String module;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @ManyToMany(mappedBy = "curriculumList", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lession> lessionList;


}

