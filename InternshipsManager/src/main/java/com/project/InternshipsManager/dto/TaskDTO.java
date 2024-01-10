package com.project.InternshipsManager.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.model.utils.StateEnum;



public class TaskDTO {
	
	private String name;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	@JsonProperty("createDate")
	private Date createDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	@JsonProperty("finishDate")
	private Date finishDate;
	private Integer estimatedHours;
	private StateEnum state;
	private String remarks;
	private Internship intership;
	
	public TaskDTO() {}
	
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
		return intership;
	}
	public void setIntership(Internship intership) {
		this.intership = intership;
	}
	
}
