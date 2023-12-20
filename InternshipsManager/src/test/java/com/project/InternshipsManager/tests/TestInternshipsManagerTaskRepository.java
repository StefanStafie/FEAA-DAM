package com.project.InternshipsManager.tests;

import static org.junit.Assert.assertEquals;
import java.sql.Date;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.project.InternshipsManager.dto.TaskDTO;
import com.project.InternshipsManager.model.Task;
import com.project.InternshipsManager.model.utils.StateEnum;
import com.project.InternshipsManager.repository.InternshipsRepository;

@SpringBootTest
public class TestInternshipsManagerTaskRepository {
	private static String url = "http://localhost:8081/api/tasks";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	InternshipsRepository internshipsRepository;
	
	@Test
	@Order(1)
	public void testAddTask() throws Exception {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setName("Import Export Application");
		taskDTO.setRemarks("");
		taskDTO.setState(StateEnum.PENDING);
		taskDTO.setDescription("OOP, Rest API, OJDBC");
		taskDTO.setCreateDate(Date.valueOf("2024-01-01"));
		taskDTO.setFinishDate(Date.valueOf("2024-01-10"));
		taskDTO.setEstimatedHours(25);
		taskDTO.setIntership(internshipsRepository.findById(1).get());
		
		ResponseEntity<Task> taskResponse = restTemplate.postForEntity(url + "/addTask", taskDTO, Task.class);
		
		assertEquals(HttpStatus.OK, taskResponse.getStatusCode());
	}
	
	@Test
	@Order(2)
	public void testGetTask() throws Exception {
		ResponseEntity<Task> taskResponse = restTemplate.getForEntity(url + "/" + 12,Task.class);
		Task task = taskResponse.getBody();
		assertEquals("12", task.getId().toString());
		assertEquals(HttpStatus.OK, taskResponse.getStatusCode());
	}
	
	
	@Test
	@Order(3)
	public void testUpdateTask() throws Exception {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setName("Import Export Java Application");
		taskDTO.setRemarks("jdk 11, JPA");
		ResponseEntity<Task> taskResponse = restTemplate.exchange(url + "/updateTask/{id}", HttpMethod.PUT,new HttpEntity<>(taskDTO), Task.class, 8);
		Task task = taskResponse.getBody();
		assertEquals(HttpStatus.OK, taskResponse.getStatusCode());
		assertEquals("Import Export Java Application", task.getName());
		assertEquals("jdk 11, JPA", task.getRemarks());
	}
	
	@Test
	@Order(4)
	public void testAssignTaskToTeam() throws Exception {
		ResponseEntity<String> taskAssigmentResponse = restTemplate.exchange(url + "?teamName=Backend Team 1&taskName=Import Export Java Application", HttpMethod.PUT, null , String.class);
		assertEquals(HttpStatus.OK, taskAssigmentResponse.getStatusCode());
	}
	
	@Test
	@Order(5)
	public void testDeleteTask() throws Exception {
		restTemplate.delete(url + "/deleteTask/" + 8, Task.class);
	}

}
