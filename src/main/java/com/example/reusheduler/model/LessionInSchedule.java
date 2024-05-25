package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;


import java.time.LocalDate;
import java.util.List;

@Table(name = "lessionInSchedule", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class LessionInSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "studyDay")
    private LocalDate studyDate;


    @ManyToOne(fetch =  FetchType.LAZY)
//    @JoinColumn(name = "scheduleList")
    @JoinColumn(name="schedule_id")

//    referencedColumnName = "id")
//    @BatchSize(size = 1000)
    private Schedule schedule;


    @ManyToOne()
//    @JoinColumn(name = "scheduleList")
    @JoinColumn(name="lession_id")

//    referencedColumnName = "id")
//    @BatchSize(size = 1000)
    private Lession lession;

    @Column(name = "professor_id")
    private Long professorId;

//    @OneToMany(mappedBy = "lessionInSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "user_id")
//    private List<LessionInSchedule> lessionInSchedules;
}