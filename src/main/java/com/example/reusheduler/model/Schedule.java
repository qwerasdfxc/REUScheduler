package com.example.reusheduler.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Table(name = "schedule", schema = "REUScheduler")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class  Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "module")
    private String module;

    @Column(name = "createDate")
    private LocalDateTime createDate;


    @OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER)
    @BatchSize(size = 3)
    private List<LessionInSchedule> scheduleList;

    @Column(name = "group_id")
    private Long groupId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) && Objects.equals(module, schedule.module) && Objects.equals(createDate, schedule.createDate) && Objects.equals(groupId, schedule.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, module, createDate, groupId);
    }
}