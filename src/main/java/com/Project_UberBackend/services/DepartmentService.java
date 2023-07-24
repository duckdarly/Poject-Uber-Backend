package com.Project_UberBackend.services;

import java.util.List;

import com.Project_UberBackend.DTOs.DepartmentDTO;
import com.Project_UberBackend.entities.Department;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;

public interface DepartmentService {
DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
List<DepartmentDTO> listDepartments();
DepartmentDTO getDepartment(Long department_id) throws DepartmentNotFoundException;
DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);
void deteleDepartment(Long department_id);
}
