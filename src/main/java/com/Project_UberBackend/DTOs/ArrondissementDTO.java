package com.Project_UberBackend.DTOs;

import com.Project_UberBackend.entities.Department;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor @AllArgsConstructor @Data
public class ArrondissementDTO {
	private Long arrondissement_id;
	private String description;
	private DepartmentDTO departmentDTO;
	private Long departments;
}
