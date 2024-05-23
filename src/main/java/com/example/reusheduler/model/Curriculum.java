package com.example.reusheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;


import java.time.LocalDate;
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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "module")
    private String module;

    @Column(name = "createDate")
    private LocalDate createDate;

    @ManyToMany(mappedBy = "curriculumList", fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Lession> lessionList;

    @ManyToOne()
    @JoinColumn(name = "group_id")
//    referencedColumnName = "id")
    @BatchSize(size = 1000)
    private Group group;

}

