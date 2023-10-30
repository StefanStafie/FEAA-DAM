package com.project.InternshipsManager.model;

import java.sql.Date;
import com.project.InternshipsManager.model.utils.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="intership")
public class Internship {
	@SequenceGenerator(name= "internship_sequence_generator", 
			   sequenceName="internship_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="internship_sequence_generator")
	@Column(name="id")
	private Integer id;
	
	@Column(name="nume_pozitie")
	private String positionName;
	
	@Column(name = "platit")
	private boolean payed;
	
	@Column(name = "numar_ore_saptamanal")
	private Integer numberOfHoursWeekly;
	
	@Column(name = "id_coordonator")
	private Integer coordinatorId;
	
	@Column(name = "id_echipa")
	private Integer teamId;
	
	@Column(name= "data_inceput")
	private Date startDate;
	
	@Column(name = "data_sfarsit")
	private Date finishDate;
	
	@Column(name = "observatii")
	private String remarks;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stare")
	private StateEnum state;
	
	@Column(name = "id_angajati_interni")
	private Integer[] internEmployeesId;
	
	public Internship() { }

	public Internship(String position_name, boolean payed, Integer numberOfHoursWeekly, Integer coordinatorId,
			Integer teamId, Date startDate, Date finishDate, String remarks, StateEnum state,
			Integer[] internEmployeesId) {
		super();
		this.positionName = position_name;
		this.payed = payed;
		this.numberOfHoursWeekly = numberOfHoursWeekly;
		this.coordinatorId = coordinatorId;
		this.teamId = teamId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.remarks = remarks;
		this.state = state;
		this.internEmployeesId = internEmployeesId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition_name() {
		return positionName;
	}

	public void setPosition_name(String position_name) {
		this.positionName = position_name;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getNumberOfHoursWeekly() {
		return numberOfHoursWeekly;
	}

	public void setNumberOfHoursWeekly(Integer numberOfHoursWeekly) {
		this.numberOfHoursWeekly = numberOfHoursWeekly;
	}

	public Integer[] getInternEmployeesId() {
		return internEmployeesId;
	}

	public void setInternEmployeesId(Integer[] internEmployeesId) {
		this.internEmployeesId = internEmployeesId;
	}

	public Integer getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Integer coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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

}
