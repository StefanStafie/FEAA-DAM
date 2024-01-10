package com.project.InternshipsManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.InternshipsManager.dto.EquipmentDTO;
import com.project.InternshipsManager.model.Equipment;
import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.repository.EquipmentRepository;
import com.project.InternshipsManager.repository.InternEmployeeRepository;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
	
	@Autowired
	EquipmentRepository equipmentRepository;
	
	@Autowired
	InternEmployeeRepository internEmployeeRepository;
	
	@PostMapping("/addEquipmentToIntern/{id}")
	public ResponseEntity<String> addEquipmentToIntern(@RequestBody EquipmentDTO equipmentDTO, @PathVariable Integer internId){
		InternEmployee internEmployee = internEmployeeRepository.findById(internId).get();
		if(internEmployee != null) {
			Equipment equipment = new Equipment(equipmentDTO.getName(), equipmentDTO.getSerialNumber(), equipmentDTO.getType(), internEmployee);
			equipment = equipmentRepository.save(equipment);
			return new ResponseEntity<String>(equipment.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<String>("Can not assign equipment to intern",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteEquipment/{id}")
	public void deleteEquipment(@PathVariable Integer id) {
		equipmentRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getEquipment(@PathVariable Integer id) {
		return new ResponseEntity<String> (equipmentRepository.findById(id).get().toString(), HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Equipment>> getEquipments() {
		return new ResponseEntity<List<Equipment>> (equipmentRepository.findAll(), HttpStatus.OK);
	}
}
