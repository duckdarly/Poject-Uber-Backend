package com.Project_UberBackend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Project_UberBackend.DTOs.CommuneDTO;
import com.Project_UberBackend.entities.Commune;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CommuneMappersImpl {
	public CommuneDTO fromCommune(Commune commune) {
		CommuneDTO communeDTO =  new CommuneDTO();
		BeanUtils.copyProperties(commune, communeDTO);
		//communeDTO.getArrondissementDTO()
		return null;
	}
	
	public Commune fromCommuneDTO(CommuneDTO communeDTO) {
		return null;
	}
}
