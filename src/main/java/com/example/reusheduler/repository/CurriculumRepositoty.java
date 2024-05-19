package com.example.reusheduler.repository;

import com.example.reusheduler.model.Curriculum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepositoty extends CrudRepository<Curriculum, Long> {
}
