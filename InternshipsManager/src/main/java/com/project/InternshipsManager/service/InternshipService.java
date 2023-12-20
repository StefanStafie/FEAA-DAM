package com.project.InternshipsManager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.Employee;
import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.model.Task;
import com.project.InternshipsManager.model.utils.GeneralUtils;
import com.project.InternshipsManager.repository.EmployeeRepository;
import com.project.InternshipsManager.repository.InternEmployeeRepository;
import com.project.InternshipsManager.repository.InternshipsRepository;

@Service
public class InternshipService {
	
	@Autowired
	private InternshipsRepository internshipsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private InternEmployeeRepository internEmployeeRepository;
	

	public InternshipService(InternshipsRepository internshipsRepository,EmployeeRepository employeeRepository) {
		super();
		this.internshipsRepository = internshipsRepository;
		this.employeeRepository = employeeRepository;
	}

	public void addInternship( InternshipDTO internshipDTO ) {
		Employee employee = GeneralUtils.getEmployeeByFullName(internshipDTO, employeeRepository);
		Internship internship = new Internship(internshipDTO.getName(), internshipDTO.isPayed(),internshipDTO.getNumberOfSeatsAvailable(),
							                internshipDTO.getNumberOfHoursWeekly(), 
											internshipDTO.getStartDate(), internshipDTO.getFinishDate(), 
											internshipDTO.getState(), internshipDTO.getDepartament(), employee);
		internshipsRepository.save(internship);
	}
	
	public void modifyInternship( InternshipDTO internshipDTO, Integer id ) {
		Internship currentInternship = internshipsRepository.findById(id).get();
		Employee employee = GeneralUtils.getEmployeeByFullName(internshipDTO, employeeRepository);
		if( employee != null ) {
		   currentInternship.setEmployee(employee);
		}
		if( !internshipDTO.getName().isEmpty() ) {
			currentInternship.setName(internshipDTO.getName());
		}
		if( internshipDTO.isPayed() ) {
			currentInternship.setPayed(internshipDTO.isPayed());
		}
		if( internshipDTO.getNumberOfHoursWeekly() > 0 ) {
			currentInternship.setNumberOfHoursWeekly(internshipDTO.getNumberOfHoursWeekly());
		}
		if( internshipDTO.getNumberOfSeatsAvailable() > 0 ) {
			currentInternship.setNumberOfSeatsAvailable(internshipDTO.getNumberOfSeatsAvailable());
		}
		
		if( internshipDTO.getStartDate() != null ) {
			currentInternship.setStartDate(internshipDTO.getStartDate());
		}
		if( internshipDTO.getFinishDate() != null ) {
			currentInternship.setFinishDate(internshipDTO.getFinishDate());
		}
		if( internshipDTO.getState() != null ) {
			currentInternship.setState(internshipDTO.getState());
		}
		if( internshipDTO.getDepartament() != null ) {
			currentInternship.setDepartament(internshipDTO.getDepartament());
		}
		internshipsRepository.save(currentInternship);
	}
	
	public Integer autoUpdateOfNumberOfSeatsAvailable(Integer id) {
		Internship internship = internshipsRepository.findById(id).get();
		List<InternEmployee> internEmployees = internEmployeeRepository.findAll();
		int numberOfSeatsOccupied = 0;
		for(InternEmployee intern: internEmployees) {
			if(intern.getInternship().getId() == id) {
				numberOfSeatsOccupied++;
			}
		}
		return internship.getNumberOfSeatsAvailable() - numberOfSeatsOccupied;
	}
	
	public List<Task> getAllTaskThatWasCreatedForInternship(Integer id){
		Internship internship = internshipsRepository.findById(id).get();
		return internship.getTasks();
	}
	
	
	public void cancelInternship(Integer id) {
		internshipsRepository.deleteById(id);
	}
	
	public Internship getInternship(Integer id) {
		return internshipsRepository.findById(id).get();
	}
	
	public List<Internship> getAllInternships(){
		return internshipsRepository.findAll();
	}
}
