package com.project.InternshipsManager.model;

import java.util.List;
import com.project.InternshipsManager.model.utils.DepartamentEnum;
import com.project.InternshipsManager.model.utils.GeneralUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="echipe")
public class Team {
	@SequenceGenerator(name= "team_sequence_generator", 
			   sequenceName="team_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="team_sequence_generator")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nume_echipa")
	private String teamName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "departament")
	private DepartamentEnum departament;
	
	 @OneToMany(mappedBy = "team")
	 private List<Employee> employees;
	 
	 @OneToMany(mappedBy = "team")
	 private List<InternEmployee> internEmployees;
	 
	 @ManyToMany
	 @JoinTable(name = "asignare_echipa_activitate", 
			    joinColumns = @JoinColumn(name = "id_echipa"), 
			    inverseJoinColumns = @JoinColumn(name = "id_activitate"))
	 private List<Task> tasks;
	
	public Team() { }

	public Team(String teamName, DepartamentEnum departament) {
		super();
		this.teamName = teamName;
		this.departament = departament;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public DepartamentEnum getDepartament() {
		return departament;
	}


	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}

	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public List<InternEmployee> getInternEmployees() {
		return internEmployees;
	}


	public void setInternEmployees(List<InternEmployee> internEmployees) {
		this.internEmployees = internEmployees;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		String employeesString = GeneralUtils.validateEmptyListOfObject(employees);
		String internEmployeesString = GeneralUtils.validateEmptyListOfObject(internEmployees);
		String tasksString = GeneralUtils.validateEmptyListOfObject(tasks);
		return "Team [id=" + id + ", teamName=" + teamName + ", departament=" + departament + ", employees=" + employeesString
				+ ", internEmployees=" + internEmployeesString + ", tasks=" + tasksString + "]";
	}
}
