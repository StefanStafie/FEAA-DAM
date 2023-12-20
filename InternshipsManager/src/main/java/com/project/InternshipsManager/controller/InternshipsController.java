package com.project.InternshipsManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.service.InternshipService;

@RestController
@RequestMapping("/api/internships")
public class InternshipsController {

	private InternshipService internshipService;
	
	public InternshipService getInternshipService() {
		return internshipService;
	}

	public void setInternshipService(InternshipService internshipService) {
		this.internshipService = internshipService;
	}

	@Autowired
	public InternshipsController(InternshipService internshipService) {
		this.internshipService = internshipService;
	}
	
	@PostMapping("/addInternship")
	 public void addInternship(@RequestBody InternshipDTO internshipDTO) {
        this.internshipService.addInternship(internshipDTO);
    }
	
	@PutMapping("/updateInternship/{id}")
	public void updateInternship(@RequestBody InternshipDTO internshipDTO, @PathVariable Integer id) {
		this.internshipService.modifyInternship(internshipDTO, id);
	}
	
	@GetMapping("/{id}")
	public Internship getInternship(@PathVariable Integer id) {
		return this.internshipService.getInternship(id);
	}
	
	@DeleteMapping("/deleteInternship/{id}")
	public void deleteInternship(@PathVariable Integer id) {
		this.internshipService.cancelInternship(id);
	}
	
	
}
