package com.project.InternshipsManager.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.InternshipsManager.model.utils.DepartamentEnum;
import com.project.InternshipsManager.model.utils.GeneralUtils;
import com.project.InternshipsManager.model.utils.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="internships")
public class Internship {
	@SequenceGenerator(name= "internship_sequence_generator", 
			   sequenceName="internship_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="internship_sequence_generator")
	@Column(name="id")
	private Integer id;
	
	@Column(name = "nume")
	private String name;
	
	@Column(name = "platit")
	private boolean payed;
	
	@Column(name = "numar_locuri_disponibile")
	private Integer numberOfSeatsAvailable;
	
	@Column(name = "numar_ore_saptamanal")
	private Integer numberOfHoursWeekly;
	
	@Column(name= "data_inceput")
	private Date startDate;
	
	@Column(name = "data_sfarsit")
	private Date finishDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stare")
	private StateEnum state;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "departament")
	private DepartamentEnum departament;
	
	@OneToMany(mappedBy = "internship", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Task> tasks;
	
	@ManyToOne
	@JoinColumn(name = "id_responsabil_internship")
	private Employee employee;
	
	public Internship() { }

	public Internship(String name, boolean payed, Integer numberOfSeatsAvailable, Integer numberOfHoursWeekly,
			Date startDate, Date finishDate, StateEnum state, DepartamentEnum departament, Employee employee) {
		super();
		this.name = name;
		this.payed = payed;
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
		this.numberOfHoursWeekly = numberOfHoursWeekly;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.state = state;
		this.departament = departament;
		this.employee = employee;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		String tasksString = GeneralUtils.validateEmptyListOfObject(tasks);
		String employeeString = GeneralUtils.validateNullObject(employee);
		return "Internship [id=" + id + ", name=" + name + ", payed=" + payed + ", numberOfSeatsAvailable="
				+ numberOfSeatsAvailable + ", numberOfHoursWeekly=" + numberOfHoursWeekly + ", startDate=" + startDate
				+ ", finishDate=" + finishDate + ", state=" + state + ", departament=" + departament + ", tasks="
				+ tasksString + ", employee=" + employeeString + "]";
	}
	
}
