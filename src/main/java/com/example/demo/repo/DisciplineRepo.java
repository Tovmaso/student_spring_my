package com.example.demo.repo;

import com.example.demo.models.Discipline;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepo extends CrudRepository<Discipline,Long> {
}
