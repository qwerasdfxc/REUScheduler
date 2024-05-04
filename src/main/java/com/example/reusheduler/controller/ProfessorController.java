package com.example.reusheduler.controller;

import com.example.reusheduler.model.Professor;
import com.example.reusheduler.repository.ProfessorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping("/test")
    public Professor test(){
        return professorRepository.save(Professor.builder().name("test testovich").workHours(123L).build());
    }

}
