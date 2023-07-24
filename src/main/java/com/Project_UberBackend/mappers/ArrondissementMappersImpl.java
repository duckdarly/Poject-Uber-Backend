package com.Project_UberBackend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Project_UberBackend.DTOs.ArrondissementDTO;
import com.Project_UberBackend.entities.Arrondissement;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArrondissementMappersImpl {
	private DepartmentMapperImpl dtoMappers;
	
	public ArrondissementDTO fromArrondissement(Arrondissement arrondissement) {
		ArrondissementDTO arrondissementDTO = new ArrondissementDTO();
		BeanUtils.copyProperties(arrondissement, arrondissementDTO);
		arrondissementDTO.setDepartmentDTO(dtoMappers.fromDepartment(arrondissement.getDepartments()));
		arrondissementDTO.setDepartments(arrondissement.getDepartments().getDepartment_id());
		return arrondissementDTO;
	}
	
	public Arrondissement fromArrondissementDTO(ArrondissementDTO arrondissementDTO) {
		Arrondissement arrondissement = new Arrondissement();
		BeanUtils.copyProperties(arrondissementDTO, arrondissement);
		arrondissement.setDepartments(dtoMappers.fromDepartmentDTO(arrondissementDTO.getDepartmentDTO()));
		return arrondissement;
	}

}
