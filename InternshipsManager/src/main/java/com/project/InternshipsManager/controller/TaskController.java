package com.project.InternshipsManager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.InternshipsManager.dto.TaskDTO;
import com.project.InternshipsManager.model.Task;
import com.project.InternshipsManager.model.TaskAssigment;
import com.project.InternshipsManager.model.Team;
import com.project.InternshipsManager.repository.TaskRepository;
import com.project.InternshipsManager.repository.TeamRepository;
import com.project.InternshipsManager.repository.TaskAssigmentRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TaskAssigmentRepository taskAssigmentRepository;

	@PostMapping("/addTask")
	public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO) {
		Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), taskDTO.getCreateDate(), 
				taskDTO.getFinishDate(), taskDTO.getEstimatedHours(), taskDTO.getState(), taskDTO.getRemarks(), taskDTO.getIntership());
		task = taskRepository.save(task);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
   }
	
   @PutMapping("/updateTask/{id}")
   public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Integer id) {
	   Task currentTask = taskRepository.findById(id).get();
		if(taskDTO.getName() != null) {
			currentTask.setName(taskDTO.getName());
		}
		if(taskDTO.getDescription() != null) {
			currentTask.setDescription(taskDTO.getDescription());
		}
		if(taskDTO.getCreateDate() != null) {
			currentTask.setCreateDate(taskDTO.getCreateDate());
		}
		if(taskDTO.getFinishDate() != null) {
			currentTask.setFinishDate(taskDTO.getFinishDate());
		}
		if(taskDTO.getEstimatedHours() != null ) {
			currentTask.setEstimatedHours(taskDTO.getEstimatedHours());
		}
		if(taskDTO.getState() != null) {
			currentTask.setState(taskDTO.getState());
		}
		if(taskDTO.getRemarks() != null) {
			currentTask.setRemarks(taskDTO.getRemarks());
		}
		currentTask = taskRepository.save(currentTask);
		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
   }
   
   @DeleteMapping("/deleteTask/{id}")
   public void deleteTask(@PathVariable Integer id) {
	   List<TaskAssigment> tasksAssigment = taskAssigmentRepository.findByTask(taskRepository.findById(id).get());
	   for(TaskAssigment taskAssigment: tasksAssigment) {
		   taskAssigmentRepository.deleteById(taskAssigment.getId());
	   }
	   taskRepository.deleteById(id);
	   
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Task> getTask(@PathVariable Integer id) {
	   return new ResponseEntity<Task>(taskRepository.findById(id).get(), HttpStatus.OK);
   }
   
   @PutMapping
   public ResponseEntity<String> assignTaskToTeam(@RequestParam String teamName, @RequestParam String taskName) {
	   Task task = taskRepository.findByName(taskName);
	   Team team = teamRepository.findByTeamName(teamName);
	   if(task != null && team != null) {
		   TaskAssigment taskAssigment = taskAssigmentRepository.save(new TaskAssigment(team, task));
		   return new ResponseEntity<String>(taskAssigment.toString(), HttpStatus.OK);
	   }
	   return new ResponseEntity<String>("Assign operation failed!", HttpStatus.BAD_REQUEST);
   }

}
