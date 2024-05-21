package com.example.reusheduler.controller;

import com.example.reusheduler.dto.DepartmentDTO;
import com.example.reusheduler.dto.DepartmentRespDTO;
import com.example.reusheduler.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

//    @PostMapping("/fill/depatment")
//    public String fillDepartment(@RequestBody DepartmentFillDTO departmentFillDTO){
//
//    }

    @GetMapping("/view/departments")
    public List<DepartmentRespDTO> viewDepartments(){
        List<DepartmentRespDTO> departmentRespDTOS = new ArrayList<>();
        departmentRepository.findAll().forEach(x -> {
            List<String> lessionsName = x.getLessionList().stream().map(y -> y.getName()).collect(Collectors.toList());
            departmentRespDTOS
                    .add(DepartmentRespDTO
                            .builder()
                            .id(x.getId())
                            .name(x.getName())
                            .lessions(lessionsName)
                            .build());
        });
        return departmentRespDTOS;
    }
}
