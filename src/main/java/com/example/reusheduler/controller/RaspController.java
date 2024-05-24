package com.example.reusheduler.controller;


import com.example.reusheduler.dto.RaspDTO;
import com.example.reusheduler.model.Schedule;
import com.example.reusheduler.repository.GroupRepository;
import com.example.reusheduler.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//первый модуль (01.09 – 31.10),
//второй модуль (01.11-31.12),
//третий модуль (01.01 – 31.03),
//четвертый модуль (01.04 – 31.06)

@RestController
@CrossOrigin

public class RaspController {

    private final ScheduleRepository scheduleRepository;


    private final GroupRepository groupRepository;
    public RaspController(ScheduleRepository scheduleRepository, GroupRepository groupRepository) {
        this.scheduleRepository = scheduleRepository;
        this.groupRepository = groupRepository;
    }


    //TODO
    @GetMapping("/view/rasp")
    public Schedule viewRasp(@RequestBody RaspDTO raspDTO){


//        groupRepository.findById(raspDTO.getGroupId())
        return null;
    }

    @PostMapping("/fill/rasp")
    public ResponseEntity viewRasasdp(@RequestBody RaspDTO raspDTO){


//        groupRepository.findById(raspDTO.getGroupId())
        return ResponseEntity.ok().build();
    }
}
