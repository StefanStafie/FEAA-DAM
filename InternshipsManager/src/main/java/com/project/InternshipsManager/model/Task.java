package com.project.InternshipsManager.model;

import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.InternshipsManager.model.utils.GeneralUtils;
import com.project.InternshipsManager.model.utils.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="activitati")
public class Task {
	@SequenceGenerator(name= "task_sequence_generator", 
			   sequenceName="task_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="task_sequence_generator")
	@Column(name="id")
	private Integer id;	
	
	@Column(name = "nume")
	private String name;
	
	@Column(name = "descriere")
	private String description;
	
	@CreationTimestamp
	@Column(name = "data_creare")
	private Date createDate;
	
	@Column(name = "termen_finalizare")
	private Date finishDate;
	
	@Column(name = "ore_estimate")
	private Integer estimatedHours;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stare")
	private StateEnum state;
	
	@Column(name = "observatii")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name = "id_internship")
	@JsonIgnore
	private Internship internship;
	
	@ManyToMany(mappedBy = "tasks")
	private List<Team> teams;
	

	public Task() { }

	public Task(String name, String description, Date createDate, Date finisDate, Integer estimatedHours,
			StateEnum state, String remarks, Internship internship) {
		super();
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.finishDate = finisDate;
		this.estimatedHours = estimatedHours;
		this.state = state;
		this.remarks = remarks;
		this.internship = internship;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getFinishDate() {
		return finishDate;
	}


	public void setFinishDate(Date finisDate) {
		this.finishDate = finisDate;
	}


	public Integer getEstimatedHours() {
		return estimatedHours;
	}


	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}


	public StateEnum getState() {
		return state;
	}


	public void setState(StateEnum state) {
		this.state = state;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Internship getIntership() {
		return internship;
	}


	public void setIntership(Internship internship) {
		this.internship = internship;
	}
	
	@Override
	public String toString() {
		String internshipString = GeneralUtils.validateNullObject(internship);
		String teamsString = GeneralUtils.validateEmptyListOfObject(teams);
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", createDate=" + createDate
				+ ", finishDate=" + finishDate + ", estimatedHours=" + estimatedHours + ", state=" + state
				+ ", remarks=" + remarks + ", internship=" + internshipString + ", teams=" + teamsString + "]";
	}
}
