package com.example.reusheduler.controller;

import com.example.reusheduler.dto.ProfessorDTO;
import com.example.reusheduler.model.Department;
import com.example.reusheduler.model.Professor;
import com.example.reusheduler.repository.DepartmentRepository;
import com.example.reusheduler.repository.ProfessorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final DepartmentRepository departmentRepository;

    public ProfessorController(ProfessorRepository professorRepository, DepartmentRepository departmentRepository) {
        this.professorRepository = professorRepository;
        this.departmentRepository = departmentRepository;
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
                .id(professorRepository.findFirstByOrderByIdDesc().getId() + 1)
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

}
