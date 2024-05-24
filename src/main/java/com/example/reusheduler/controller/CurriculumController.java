package com.example.reusheduler.controller;

import com.example.reusheduler.dto.CirriculumDTO;
import com.example.reusheduler.model.Curriculum;
import com.example.reusheduler.model.Group;
import com.example.reusheduler.model.Lession;
import com.example.reusheduler.repository.CurriculumRepositoty;
import com.example.reusheduler.repository.GroupRepository;
import com.example.reusheduler.repository.LessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class CurriculumController {

    private final CurriculumRepositoty curriculumRepositoty;

    private final LessionRepository lessionRepository;

    private final GroupRepository groupRepository;


    public CurriculumController(CurriculumRepositoty curriculumRepositoty, LessionRepository lessionRepository, GroupRepository groupRepository) {
        this.curriculumRepositoty = curriculumRepositoty;
        this.lessionRepository = lessionRepository;
        this.groupRepository = groupRepository;
    }


    //TODO
    @GetMapping("/view/curriculum")
    public ResponseEntity<List<Curriculum>> viewCurriculum(@RequestParam(required = false) Long groupId,
                                                           @RequestParam(required = false) Long module
    ) {

        if (Objects.isNull(groupId) && Objects.isNull(module)) {
            List<Curriculum> curriculumList = new ArrayList<>();
            curriculumRepositoty.findAll().forEach(x -> curriculumList.add(x));
            return ResponseEntity.badRequest().build();
        }

        List<Curriculum> repositotyAllByGroup = curriculumRepositoty.findAllByGroup(groupRepository.findById(groupId).get());

//        repositotyAllByGroup.forEach(curr -> curr.get);

        return ResponseEntity.ok(repositotyAllByGroup);

//        if(Objects.isNull(groupId)){
//
//        }
//        else {
//
//        }
//        return null;
    }

    //TODO
    @PostMapping("/fill/curriculum")
    public ResponseEntity<Object> fillcirr(@RequestBody CirriculumDTO cirriculumDTO) {

        if (cirriculumDTO.getModule() > 4 || cirriculumDTO.getModule() < 1)
            return ResponseEntity.badRequest().build();

        List<Curriculum> curriculumList = new ArrayList<>();
        curriculumRepositoty.findAll().forEach(x -> curriculumList.add(x));
//        Group group =
//        if(curriculumRepositoty.findByGroupAndModule())
        List<Lession> lessions = new ArrayList<>();
        cirriculumDTO.getLessons().forEach(x -> {
//            Lession lession = lessionRepository.findById(x.getLessonId()).get();
            Lession lession = Lession.builder().id(x.getLessonId()).build();

            lessions.add(lession);
        });
        Curriculum curriculumdb = curriculumRepositoty.findFirstByOrderByIdDesc();
        Curriculum curriculum = Curriculum
                .builder()
                .createDate(LocalDate.now())
                .module(String.valueOf(cirriculumDTO.getModule()))
                .id(curriculumdb.getId()+1)
                .lessionList(lessions)
                .group(Group.builder().id(cirriculumDTO.getGroupId()).build())
                .build();

        curriculumRepositoty.save(curriculum);
        return ResponseEntity.ok().build();
    }
}
