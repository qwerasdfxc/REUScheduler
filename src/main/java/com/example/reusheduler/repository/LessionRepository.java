package com.example.reusheduler.repository;

import com.example.reusheduler.model.Group;
import com.example.reusheduler.model.Lession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessionRepository extends CrudRepository<Lession, Long> {
}
