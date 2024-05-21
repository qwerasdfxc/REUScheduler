package com.example.reusheduler.controller;

import com.example.reusheduler.dto.DepartmentFillDTO;
import com.example.reusheduler.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/fill/depatment")
    public String fillDepartment(@RequestBody DepartmentFillDTO departmentFillDTO){

    }
}
