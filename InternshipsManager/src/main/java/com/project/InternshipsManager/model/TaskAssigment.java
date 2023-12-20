package com.project.InternshipsManager.model;

import com.project.InternshipsManager.model.utils.GeneralUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="asignare_echipa_activitate")
public class TaskAssigment {
	@SequenceGenerator(name= "team_task_sequence_generator", 
			   sequenceName="team_task_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="team_task_sequence_generator")
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_echipa")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "id_activitate")
	private Task task;
	
	public TaskAssigment() { }

	public TaskAssigment(Team team, Task task) {
		super();
		this.team = team;
		this.task = task;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		String taskString = GeneralUtils.validateNullObject(task);
		String teamString = GeneralUtils.validateNullObject(team);
		return "TaskAssigment [id=" + id + ", team=" + teamString + ", task=" + taskString + "]";
	}
}
