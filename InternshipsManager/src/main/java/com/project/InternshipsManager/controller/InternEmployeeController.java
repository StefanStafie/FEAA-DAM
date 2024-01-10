package com.project.InternshipsManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.InternshipsManager.dto.InternEmployeeDTO;
import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.model.Team;
import com.project.InternshipsManager.repository.InternEmployeeRepository;
import com.project.InternshipsManager.repository.InternshipsRepository;
import com.project.InternshipsManager.repository.TeamRepository;

@RestController
@RequestMapping("/api/interns")
public class InternEmployeeController {

	@Autowired
	InternEmployeeRepository internEmployeeRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	InternshipsRepository internshipsRepository;
	
	@PostMapping("/addIntern")
	public ResponseEntity<String> addIntern(@RequestBody InternEmployeeDTO internEmployeeDTO ){
		
		
			InternEmployee internEmployee = new InternEmployee(internEmployeeDTO.getLastName(), internEmployeeDTO.getFirstName(), 
															   internEmployeeDTO.getContact(), internEmployeeDTO.getDepartament(), 
															   internEmployeeDTO.getSpecialization(), null, null);
			internEmployee = internEmployeeRepository.save(internEmployee);
			return new ResponseEntity<String>(internEmployee.toString(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteIntern/{id}")
	public void deleteIntern(@PathVariable Integer  id) {
		internEmployeeRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getIntern(@PathVariable Integer id) {
		return new ResponseEntity<String>(internEmployeeRepository.findById(id).get().toString(), HttpStatus.OK);
	}
	
	
	@GetMapping("")
	public ResponseEntity<Object> getAllInterns() {
		List<InternEmployee> x  = internEmployeeRepository.findAll();
		for(int i = 0; i< x.size(); i++) {
			x.get(i).setEquipments(null);
			x.get(i).setReviews(null);
			x.get(i).setTeam(null);
		}
	
		
		return new ResponseEntity<Object>(x, HttpStatus.OK);
	}
	
	
	  @GetMapping("/internsByInternship/{internshipId}")
	    public ResponseEntity<List<InternEmployee>> getInternsByInternship(@PathVariable Integer internshipId) {
	        List<InternEmployee> interns = internEmployeeRepository.findByInternship_Id(internshipId);

	        if (interns != null && !interns.isEmpty()) {
	            return new ResponseEntity<>(interns, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	@PutMapping("/updateInternData/{id}")
	public ResponseEntity<String> updateInternData(@RequestBody InternEmployeeDTO internEmployeeDTO, @PathVariable Integer id){
		InternEmployee currentInternEmployee = internEmployeeRepository.findById(id).get();
		Team team = teamRepository.findByTeamName(internEmployeeDTO.getTeamName());
		Internship internship = internshipsRepository.findByName(internEmployeeDTO.getInternshipName());
		
		if(currentInternEmployee == null) {
			return new ResponseEntity<String>("Update intern's data is not possible!", HttpStatus.BAD_REQUEST);
		}
		if(internEmployeeDTO.getLastName() != null) {
			currentInternEmployee.setLastName(internEmployeeDTO.getLastName());
		}
		if(internEmployeeDTO.getFirstName() != null) {
			currentInternEmployee.setFirstName(internEmployeeDTO.getFirstName());
		}
		if(internEmployeeDTO.getContact() != null) {
			currentInternEmployee.setContact(internEmployeeDTO.getContact());
		}
		if(internEmployeeDTO.getSpecialization() != null) {
			currentInternEmployee.setSpecialization(internEmployeeDTO.getSpecialization());
		}
		if(internEmployeeDTO.getDepartament() != null) {
			currentInternEmployee.setDepartament(internEmployeeDTO.getDepartament());
		}
		if(internship != null) {
			currentInternEmployee.setInternship(internship);
		}
		if(team != null) {
			currentInternEmployee.setTeam(team);
		}
		currentInternEmployee = internEmployeeRepository.save(currentInternEmployee);
		return new ResponseEntity<String>("The intern's data has been updated successfully!", HttpStatus.OK);
	}
	
	@GetMapping("/internTasks/{id}")
	public ResponseEntity<String> getInternEmployeeTasks(@PathVariable Integer id){
		InternEmployee internEmployee = internEmployeeRepository.findById(id).get();
		Team team = internEmployee.getTeam();
		return new ResponseEntity<String> (team.getTasks().toString(), HttpStatus.OK);
	}

}
