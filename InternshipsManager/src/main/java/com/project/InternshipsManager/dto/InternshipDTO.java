package com.project.InternshipsManager.dto;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.InternshipsManager.model.utils.DepartamentEnum;
import com.project.InternshipsManager.model.utils.StateEnum;


public class InternshipDTO {
	private String name;
	private boolean payed;
	private Integer numberOfSeatsAvailable;
	private Integer numberOfHoursWeekly;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date finishDate;
	private StateEnum state;
	private DepartamentEnum departament;
	private String coordinatorName;

	public InternshipDTO() {}

	public InternshipDTO(String name, boolean payed, Integer numberOfSeatsAvailable, Integer numberOfHoursWeekly,
			Date startDate, Date finishDate, StateEnum state, DepartamentEnum departament, String coordinatorName) {
		super();
		this.name = name;
		this.payed = payed;
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
		this.numberOfHoursWeekly = numberOfHoursWeekly;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.state = state;
		this.departament = departament;
		this.coordinatorName = coordinatorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public Integer getNumberOfSeatsAvailable() {
		return numberOfSeatsAvailable;
	}

	public void setNumberOfSeatsAvailable(Integer numberOfSeatsAvailable) {
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}

	public Integer getNumberOfHoursWeekly() {
		return numberOfHoursWeekly;
	}

	public void setNumberOfHoursWeekly(Integer numberOfHoursWeekly) {
		this.numberOfHoursWeekly = numberOfHoursWeekly;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public DepartamentEnum getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}
	
}
