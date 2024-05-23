package com.example.reusheduler.controller;


import com.example.reusheduler.dto.RaspDTO;
import com.example.reusheduler.model.Schedule;
import com.example.reusheduler.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//первый модуль (01.09 – 31.10),
//второй модуль (01.11-31.12),
//третий модуль (01.01 – 31.03),
//четвертый модуль (01.04 – 31.06)

@RestController
public class RaspController {

    private final ScheduleRepository scheduleRepository;

    public RaspController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //TODO
    @GetMapping("/view/rasp")
    public Schedule viewRasp(@RequestBody RaspDTO raspDTO){
        return null;
    }
}
