package com.example.reusheduler.repository;

//import com.example.reusheduler.model.Group;
import com.example.reusheduler.model.LessionInSchedule;
import com.example.reusheduler.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LessionInScheduleRepository extends CrudRepository<LessionInSchedule, Long> {

    LessionInSchedule findBySchedule(Schedule schedule);
}