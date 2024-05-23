package com.example.reusheduler.repository;

import com.example.reusheduler.model.LessionInSchedule;
import com.example.reusheduler.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}