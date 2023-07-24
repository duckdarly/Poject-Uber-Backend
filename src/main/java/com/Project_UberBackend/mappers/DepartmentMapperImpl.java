package com.Project_UberBackend.mappers;

import org.springframework.stereotype.Service;

import com.Project_UberBackend.DTOs.DepartmentDTO;
import com.Project_UberBackend.entities.Department;
@Service
public class DepartmentMapperImpl {
	
public DepartmentDTO fromDepartment(Department department) {
	DepartmentDTO departmentDTO=new DepartmentDTO();
	departmentDTO.setDepartment_id(department.getDepartment_id());
	departmentDTO.setDescription(department.getDescription());
	return departmentDTO;
}

public Department fromDepartmentDTO(DepartmentDTO departmentDTO) {
	Department department = new Department();
	department.setDepartment_id(departmentDTO.getDepartment_id());
	department.setDescription(departmentDTO.getDescription());
	return department;
}

}
