package com.example.reusheduler.controller;


import com.example.reusheduler.dto.SchedDTO;
import com.example.reusheduler.model.Group;
import com.example.reusheduler.model.LessionInSchedule;
import com.example.reusheduler.model.Professor;
import com.example.reusheduler.model.Schedule;
import com.example.reusheduler.repository.GroupRepository;
import com.example.reusheduler.repository.ProfessorRepository;
import com.example.reusheduler.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.reusheduler.repository.LessionInScheduleRepository;

import java.time.LocalDate;


//первый модуль (01.09 – 31.10),
//второй модуль (01.11-31.12),
//третий модуль (01.01 – 31.03),
//четвертый модуль (01.04 – 31.06)

@RestController
@CrossOrigin

public class RaspController {

    private final ScheduleRepository scheduleRepository;

    private final GroupRepository groupRepository;

    private final LessionInScheduleRepository lessionInScheduleRepository;

    private final ProfessorRepository professorRepository;

    public RaspController(ScheduleRepository scheduleRepository, GroupRepository groupRepository, LessionInScheduleRepository lessionInScheduleRepository, ProfessorRepository professorRepository) {
        this.scheduleRepository = scheduleRepository;
        this.groupRepository = groupRepository;
        this.lessionInScheduleRepository = lessionInScheduleRepository;
        this.professorRepository = professorRepository;
    }


    //TODO
    @GetMapping("/view/rasp")
//    public Schedule viewRasp(@RequestBody ScheduleIdDTO scheduleIdDTO){
    public SchedDTO viewRasp(@RequestParam Long scheduleId ){

        Schedule schedule = scheduleRepository.findById(scheduleId).get();


        Group group = groupRepository.findById(schedule.getGroupId()).get();
        LessionInSchedule lessionInSchedule = lessionInScheduleRepository.findBySchedule(schedule);
        Professor professor = professorRepository.findById(lessionInSchedule.getProfessorId()).get();
        SchedDTO schedDTO = SchedDTO
                .builder()
                .id(schedule.getId())
                .createDate(LocalDate.from(schedule.getCreateDate()))
                .module(schedule.getModule())
                .groupName(group.getGroupNumber())
                .number(lessionInSchedule.getNumber())
                .name(professor.getProfessorName())
                .build();




        return schedDTO;

    }

    @PostMapping("/fill/rasp")
    public ResponseEntity viewRasasdp(){


//        groupRepository.findById(raspDTO.getGroupId())
        return ResponseEntity.ok().build();
    }
}
