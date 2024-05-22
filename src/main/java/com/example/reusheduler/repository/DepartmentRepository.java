package com.example.reusheduler.repository;

import com.example.reusheduler.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    boolean existsByName(String name);

    Department findFirstByOrderByIdDesc();

}
