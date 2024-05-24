package com.example.reusheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

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
    @JsonIgnore
    private List<Department> departmentList;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lessionInCirriculum", schema = "REUScheduler",
            joinColumns = @JoinColumn(name = "curriculum_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Curriculum> curriculumList;


//    @ManyToOne()
//    @JoinColumn(name = "lession_in_schedule_id")
////    referencedColumnName = "id")
//    @BatchSize(size = 1000)
//    private LessionInSchedule lessionInSchedule;


//    @OneToMany(mappedBy = "lessionInSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "user_id")
//    private List<LessionInSchedule> lessionInSchedules;

    @OneToMany(mappedBy = "lession")
    private List<LessionInSchedule> scheduleList;
}