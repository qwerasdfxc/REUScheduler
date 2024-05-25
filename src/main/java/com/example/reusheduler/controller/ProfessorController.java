package com.example.reusheduler.controller;

import com.example.reusheduler.dto.ProfessorDTO;
import com.example.reusheduler.dto.SchedDTO;
import com.example.reusheduler.dto.ScheduleIdDTO;
import com.example.reusheduler.model.*;
import com.example.reusheduler.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final DepartmentRepository departmentRepository;

    private final ScheduleRepository scheduleRepository;

    private final GroupRepository groupRepository;

    private final LessionInScheduleRepository lessionInScheduleRepository;


    public ProfessorController(ProfessorRepository professorRepository, DepartmentRepository departmentRepository, ScheduleRepository scheduleRepository, GroupRepository groupRepository, LessionInScheduleRepository lessionInScheduleRepository) {
        this.professorRepository = professorRepository;
        this.departmentRepository = departmentRepository;
        this.scheduleRepository = scheduleRepository;
        this.groupRepository = groupRepository;
        this.lessionInScheduleRepository = lessionInScheduleRepository;
    }

//    @GetMapping("/test")
//    public Professor test(){
//        return professorRepository.save(Professor.builder().name("test testovich").workHours(123L).build());
//    }

    @PostMapping("/fill/professor")
    public ResponseEntity<String> saveProfessor(@RequestBody ProfessorDTO professorDTO) {
        Department department = departmentRepository.findById(professorDTO.getDepartmentId()).get();
        Professor professor = Professor.builder()
                .professorName(professorDTO.getProfessorName())
                .workHours(professorDTO.getWorkHours())
                .department(department)
                .id(professorRepository.findFirstByOrderByIdDesc().getId() + (long)(Math.random()*100))
                .build();
        professorRepository.save(professor);
        return ResponseEntity.ok().body("{\"sussess\":true}");
    }

    @GetMapping("/view/professors")
    public ResponseEntity<List<ProfessorDTO>> getAll() {
        return ResponseEntity.ok(professorRepository.findAll().stream().map(professor ->
                                ProfessorDTO
                                        .builder()
                                        .professorName(professor.getProfessorName())
                                        .workHours(professor.getWorkHours())
                                        .departmentName(professor.getDepartment().getName())
                                        .id(professor.getId())
                                        .build()

                        )
                        .collect(Collectors.toList())
        );
    }



    //TODO
    @GetMapping("/view/rasp")
    public SchedDTO viewRasp(@RequestBody ScheduleIdDTO scheduleIdDTO){
//    public SchedDTO viewRasp(@RequestParam Long scheduleId ){

        Long scheduleId = Long.valueOf(scheduleIdDTO.getScheduleId());
        Schedule schedule = scheduleRepository.findById(scheduleId).get();


        Group group = groupRepository.findById(schedule.getGroupId()).get();
        LessionInSchedule lessionInSchedule = lessionInScheduleRepository.findFirstBySchedule(schedule);
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

}
