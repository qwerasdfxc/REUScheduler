package com.example.reusheduler.repository;

import com.example.reusheduler.model.Curriculum;
import com.example.reusheduler.model.Department;
import com.example.reusheduler.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    boolean existsByGroupNumber(String groupNumber);

    Group findFirstByOrderByIdDesc();

}
