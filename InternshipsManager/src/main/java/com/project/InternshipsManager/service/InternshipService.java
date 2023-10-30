package com.project.InternshipsManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.model.utils.StateEnum;
import com.project.InternshipsManager.repository.InternEmployeeRepository;
import com.project.InternshipsManager.repository.InternshipsRepository;
import com.project.InternshipsManager.repository.MentorRepository;
import com.project.InternshipsManager.repository.TeamRepository;

import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
public class InternshipService {
	
	@Autowired
	private InternshipsRepository internshipsRepository;

	@Autowired
	private MentorRepository mentorRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private InternEmployeeRepository internEmployeeRepository;
	
	public Internship addInternship( InternshipDTO internshipDTO ) {
		
		Integer mentorId = getMentorIdFromMentorName(internshipDTO.getCoordinatorName());
		Integer teamId = getTeamIdFromTeamName(internshipDTO.getTeamName());
		Integer[] internEmployeesId = getInternEmployeesIdFromEmployeesName(internshipDTO.getInternEmployeesName());
		
		Internship internship = new Internship( internshipDTO.getPositionName(), internshipDTO.isPayed(), 
					internshipDTO.getNumberOfHoursWeekly(), mentorId, 
					teamId, internshipDTO.getStartDate(), internshipDTO.getFinishDate(),
					internshipDTO.getRemarks(), StateEnum.PENDING, internEmployeesId);
		
		internshipsRepository.save(internship);
		return internship;
	}
	
	private Integer getMentorIdFromMentorName(String name) {
		return mentorRepository.findByName(name).getMentorId();
	}
	
	private Integer getTeamIdFromTeamName(String name) {
		return teamRepository.findByTeamName(name).getTeamId();
	}
	
	private Integer[] getInternEmployeesIdFromEmployeesName(String names) {
		String[] internalEmployeesNameArray = names.split(",");
		Integer[] employeesId = new Integer[internalEmployeesNameArray.length];
		
		for(int i=0; i<internalEmployeesNameArray.length; i++) {
			
			InternEmployee internEmployee = internEmployeeRepository.findByName(internalEmployeesNameArray[i]);
			employeesId[i] = internEmployee.getId();
		}
		return employeesId;
	}
}
