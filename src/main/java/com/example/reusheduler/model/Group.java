package com.example.reusheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;


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

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @BatchSize(size = 1000)
    @JsonIgnore
    private List<Curriculum> curriculum;
}