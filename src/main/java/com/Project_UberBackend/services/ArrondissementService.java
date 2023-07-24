package com.Project_UberBackend.services;

import java.util.List;

import com.Project_UberBackend.DTOs.ArrondissementDTO;
import com.Project_UberBackend.exceptions.ArrondissementNotFound;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;

public interface ArrondissementService {
	ArrondissementDTO saveArrondissement(ArrondissementDTO arrondissementDTO) throws DepartmentNotFoundException;
	List<ArrondissementDTO> listArrondissement();
	ArrondissementDTO getArrondissement(Long arrondissement_id) throws ArrondissementNotFound;
	
		void deleteArrondissement(Long arrondissement_id);
	ArrondissementDTO updateArrondissement(ArrondissementDTO arrondissementDTO,Long arrondissement_id)
			throws DepartmentNotFoundException;
}
