package com.example.reusheduler.controller;

import com.example.reusheduler.dto.LessionDTO;
import com.example.reusheduler.model.Curriculum;
import com.example.reusheduler.repository.CurriculumRepositoty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class CurriculumController {

    private final CurriculumRepositoty curriculumRepositoty;

    public CurriculumController(CurriculumRepositoty curriculumRepositoty) {
        this.curriculumRepositoty = curriculumRepositoty;
    }


    //TODO
    @GetMapping("/view/curriculum")
    public ResponseEntity<List<Curriculum>> viewCurriculum(@RequestParam(required = false) Long groupId,
                                           @RequestParam(required = false) Long module
                                           ){

        if(Objects.isNull(groupId) && Objects.isNull(module)){
            List<Curriculum> curriculumList = new ArrayList<>();
             curriculumRepositoty.findAll().forEach(x -> curriculumList.add(x));
             return ResponseEntity.badRequest().build();
        }


//        if(Objects.isNull(groupId)){
//
//        }
//        else {
//
//        }
        return null;
    }
}
