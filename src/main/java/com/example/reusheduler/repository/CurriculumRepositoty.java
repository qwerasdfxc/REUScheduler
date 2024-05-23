package com.example.reusheduler.repository;

import com.example.reusheduler.model.Curriculum;
import com.example.reusheduler.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumRepositoty extends CrudRepository<Curriculum, Long> {

    Curriculum findByGroupAndModule(Group group, String module);

    Curriculum findFirstByOrderByIdDesc();

    List<Curriculum> findAllByGroup(Group group);
}
