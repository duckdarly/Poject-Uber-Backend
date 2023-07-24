package com.Project_UberBackend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Project_UberBackend.DTOs.DepartmentDTO;
import com.Project_UberBackend.entities.Department;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;
import com.Project_UberBackend.mappers.DepartmentMapperImpl;
import com.Project_UberBackend.repositories.DepartmentRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentRepository departmentRepository;
	private DepartmentMapperImpl dtoMapper;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		log.info("Saving Department");
		Department department = dtoMapper.fromDepartmentDTO(departmentDTO); 
		Department saveDepartment = departmentRepository.save(department);
		return dtoMapper.fromDepartment(saveDepartment);
	}

	@Override
	public DepartmentDTO getDepartment(Long department_id) throws DepartmentNotFoundException {
	Department department =	departmentRepository.findById(department_id)
		.orElseThrow(()->new DepartmentNotFoundException("Department Not Found"));
		return dtoMapper.fromDepartment(department);
	}

	@Override
	public List<DepartmentDTO> listDepartments() {
		List<Department> departments = departmentRepository.findAll();
		
		List<DepartmentDTO> departmentDTOs = new ArrayList<>();
		for(Department department:departments) {
			DepartmentDTO departmentDTO = dtoMapper.fromDepartment(department);
			departmentDTOs.add(departmentDTO);
		}
		return departmentDTOs;
	}
	
	@Override
	public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
		log.info("Saving Department");
		Department department = dtoMapper.fromDepartmentDTO(departmentDTO); 
		Department saveDepartment = departmentRepository.save(department);
		return dtoMapper.fromDepartment(saveDepartment);
	}
	@Override
	public void deteleDepartment(Long department_id) {
		departmentRepository.deleteById(department_id);
	}

}
