package com.example.reusheduler.controller;

import com.example.reusheduler.dto.DepartmentDTO;
import com.example.reusheduler.dto.DepartmentRespDTO;
import com.example.reusheduler.model.Department;
import com.example.reusheduler.model.Lession;
import com.example.reusheduler.repository.DepartmentRepository;
import com.example.reusheduler.repository.LessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin

public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    private final LessionRepository lessionRepository;

    public DepartmentController(DepartmentRepository departmentRepository, LessionRepository lessionRepository) {
        this.departmentRepository = departmentRepository;
        this.lessionRepository = lessionRepository;
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

    @PostMapping("/fill/department")
    public ResponseEntity<Object> saveDepartments(@RequestBody DepartmentDTO departmentDTO){
        if(departmentRepository.existsByName(departmentDTO.getName())){
            return ResponseEntity.badRequest().build();
        }
        else {
            List<Lession> lessions = new ArrayList<>();
            departmentDTO.getLessions().forEach(x -> lessions.add(lessionRepository.findById(x).get()));
            Department departmentdb = departmentRepository.findFirstByOrderByIdDesc();
            Department department = Department
                    .builder()
                    .id(departmentdb.getId() +  (long)(Math.random()*200))
                    .name(departmentDTO.getName())
                    .lessionList(lessions)
                    .build();
            departmentRepository.save(department);
            return ResponseEntity.ok().build();
        }
    }

}
