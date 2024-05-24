package com.example.reusheduler.controller;

import com.example.reusheduler.dto.LessionDTO;
import com.example.reusheduler.model.Lession;
import com.example.reusheduler.repository.LessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class LessionController {

    private final LessionRepository lessionRepository;

    public LessionController(LessionRepository lessionRepository) {
        this.lessionRepository = lessionRepository;
    }

    @GetMapping("/view/lessons")
    public List<LessionDTO> getLessions(){
        List<LessionDTO> lessionDTOS = new ArrayList<>();
        lessionRepository.findAll().forEach(x ->
                lessionDTOS.add(LessionDTO
                        .builder()
                        .id(x.getId())
                        .name(x.getName())
                        .build()));
        return lessionDTOS;
    }
}
