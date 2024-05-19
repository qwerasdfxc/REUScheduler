package com.example.reusheduler.repository;

import com.example.reusheduler.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Professor findFirstByOrderByIdDesc();
}
