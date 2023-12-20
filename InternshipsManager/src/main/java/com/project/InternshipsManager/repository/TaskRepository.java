package com.project.InternshipsManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Task;

@EnableJpaRepositories
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer>{
	Task findByName(String name);
	Optional<Task> findById(Integer id);
}
