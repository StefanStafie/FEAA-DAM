package com.project.InternshipsManager.dto;

import java.sql.Date;

import com.project.InternshipsManager.model.utils.StateEnum;


public class InternshipDTO {
	private Integer id;
	private String positionName;
	private boolean payed;
	private Integer numberOfHoursWeekly;
	private String coordinatorName;
	private String teamName;
	private String startDate;
	private String finishDate;
	private String remarks;
	private StateEnum state;
	private String internEmployeesName;
	
	public InternshipDTO() {}

	public InternshipDTO(String positionName, boolean payed, Integer numberOfHoursWeekly, String coordinatorName,
			String teamName, String startDate, String finishDate, String remarks, String internEmployeesName) {
		super();
		this.positionName = positionName;
		this.payed = payed;
		this.numberOfHoursWeekly = numberOfHoursWeekly;
		this.coordinatorName = coordinatorName;
		this.teamName = teamName;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.remarks = remarks;
		this.internEmployeesName = internEmployeesName;
	}

	public String getPositionName() {
		return positionName;
	}


	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}


	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public Integer getNumberOfHoursWeekly() {
		return numberOfHoursWeekly;
	}

	public void setNumberOfHoursWeekly(Integer numberOfHoursWeekly) {
		this.numberOfHoursWeekly = numberOfHoursWeekly;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Date getStartDate() {
		return Date.valueOf(this.startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return Date.valueOf(this.finishDate);
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public String getInternEmployeesName() {
		return internEmployeesName;
	}

	public void setInternEmployeesName(String internEmployeesName) {
		this.internEmployeesName = internEmployeesName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
