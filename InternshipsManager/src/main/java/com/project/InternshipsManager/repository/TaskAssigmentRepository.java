package com.project.InternshipsManager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.project.InternshipsManager.model.Task;
import com.project.InternshipsManager.model.TaskAssigment;

@EnableJpaRepositories
@Repository
public interface TaskAssigmentRepository extends JpaRepository<TaskAssigment,Integer>{
	List<TaskAssigment> findByTask(Task task);
}
