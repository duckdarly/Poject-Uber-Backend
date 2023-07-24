package com.Project_UberBackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project_UberBackend.DTOs.DepartmentDTO;
import com.Project_UberBackend.entities.Department;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;
import com.Project_UberBackend.services.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DepartmentController {
private DepartmentService departmentService;

@GetMapping("/departments")
public List<DepartmentDTO> departments(){
	return departmentService.listDepartments();
}

@GetMapping("/departments/{id}")
public DepartmentDTO getDepartment(@PathVariable(name="id") Long department_id) throws DepartmentNotFoundException {
	return departmentService.getDepartment(department_id);
}

@PostMapping("/departments")
public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
	return departmentService.saveDepartment(departmentDTO);
}



@PutMapping("/departments/{id}")
public DepartmentDTO updateDepartment(@PathVariable(name="id") Long department_id, @RequestBody DepartmentDTO departmentDTO) {
	departmentDTO.setDepartment_id(department_id);
	return departmentService.updateDepartment(departmentDTO);
}
@DeleteMapping("/departments/{id}")
public void deleteDepartment(@PathVariable Long id) {
	departmentService.deteleDepartment(id);
}
}
