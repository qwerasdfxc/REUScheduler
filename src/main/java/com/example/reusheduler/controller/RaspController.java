package com.example.reusheduler.controller;


import com.example.reusheduler.dto.SchedDTO;
import com.example.reusheduler.dto.ScheduleIdDTO;
import com.example.reusheduler.model.Group;
import com.example.reusheduler.model.LessionInSchedule;
import com.example.reusheduler.model.Professor;
import com.example.reusheduler.model.Schedule;
import com.example.reusheduler.repository.GroupRepository;
import com.example.reusheduler.repository.ProfessorRepository;
import com.example.reusheduler.repository.ScheduleRepository;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.reusheduler.repository.LessionInScheduleRepository;

import java.time.LocalDate;


//первый модуль (01.09 – 31.10),
//второй модуль (01.11-31.12),
//третий модуль (01.01 – 31.03),
//четвертый модуль (01.04 – 31.06)

@RestController
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



    @PostMapping("/fill/rasp")
    public ResponseEntity viewRasasdp(){


//        groupRepository.findById(raspDTO.getGroupId())
        return ResponseEntity.ok().build();
    }
}
