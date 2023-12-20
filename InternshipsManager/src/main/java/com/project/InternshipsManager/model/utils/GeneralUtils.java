package com.project.InternshipsManager.model.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.Employee;
import com.project.InternshipsManager.repository.EmployeeRepository;

public class GeneralUtils {
	
	public static String validateNullObject(Object object) {
		if(object == null) {
			return "";
		}
		return object.toString();
	}
	
	public static String validateEmptyListOfObject(Object... objects) {
		if(objects.length == 0) {
			return "{}";
		}
		return objects.toString();
	}
	
	public static Employee getEmployeeByFullName(InternshipDTO internshipDTO, EmployeeRepository employeeRepository) {
		List<Employee> employees = employeeRepository.findAll().stream()
                .filter(employee -> employee.getLastName().equals(internshipDTO.getLastNameOfCoordinator()) &&
             		               employee.getFirstName().equals(internshipDTO.getFirstNameOfCoordinator()))
                .collect(Collectors.toList());
		return employees.get(0);
	}

}
