package com.Project_UberBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Project_UberBackend.DTOs.ArrondissementDTO;
import com.Project_UberBackend.DTOs.DepartmentDTO;
import com.Project_UberBackend.entities.Arrondissement;
import com.Project_UberBackend.entities.Department;
import com.Project_UberBackend.exceptions.ArrondissementNotFound;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;
import com.Project_UberBackend.mappers.ArrondissementMappersImpl;
import com.Project_UberBackend.repositories.ArrondissementRepository;
import com.Project_UberBackend.repositories.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@Service
@Slf4j
public class ArrondissementServiceImpl implements ArrondissementService{
private DepartmentRepository departmentRepository;
private ArrondissementRepository arrondissementRepository;
private ArrondissementMappersImpl dtoArrMappers;
	@Override
	public ArrondissementDTO saveArrondissement(ArrondissementDTO arrondissementDTO) throws DepartmentNotFoundException{
		Department department = departmentRepository.findById(arrondissementDTO.getDepartments()).orElse(null);
		if(department==null)
			throw new DepartmentNotFoundException("Department not Found");
		log.info("Saving Arrondissement");
		Arrondissement arrondissement = new Arrondissement();
		arrondissement.setDepartments(department);
		arrondissement.setDescription(arrondissementDTO.getDescription());
		Arrondissement arrondissements = arrondissementRepository.save(arrondissement);
		return dtoArrMappers.fromArrondissement(arrondissements);
	}

	@Override
	public List<ArrondissementDTO> listArrondissement() {
	    List<Arrondissement> arrondissements = arrondissementRepository.findAll();

	    List<ArrondissementDTO> arrondissementDTOs = new ArrayList<>();
	    for (Arrondissement arrondissement : arrondissements) {
	        ArrondissementDTO arrondissementDTO = dtoArrMappers.fromArrondissement(arrondissement);
	        arrondissementDTOs.add(arrondissementDTO);
	    }
	    return arrondissementDTOs;
	}

/*
 * List<DepartmentDTO> departmentDTOs = new ArrayList<>(); for(Department
 * department:departments) { DepartmentDTO departmentDTO =
 * dtoMapper.fromDepartment(department); departmentDTOs.add(departmentDTO); }
 */
	

	@Override
	public ArrondissementDTO getArrondissement(Long arrondissement_id) throws ArrondissementNotFound {
		Arrondissement arrondissement = arrondissementRepository.findById(arrondissement_id)
				.orElseThrow(()->new ArrondissementNotFound("Arrondissement Not Found"));
		return dtoArrMappers.fromArrondissement(arrondissement);
	}

	@Override
	public void deleteArrondissement(Long arrondissement_id) {
		arrondissementRepository.deleteById(arrondissement_id);
		
	}

	@Override
	public ArrondissementDTO updateArrondissement(ArrondissementDTO arrondissementDTO, Long arrondissement_id)
			throws DepartmentNotFoundException {
		Department department = departmentRepository.findById(arrondissementDTO.getDepartments()).orElse(null);
		if(department==null)
			throw new DepartmentNotFoundException("Department not Found");
		log.info("Saving Arrondissement");
		Optional<Arrondissement> arrondissement = arrondissementRepository.findById(arrondissement_id);
		arrondissement.get().setDepartments(department);
		arrondissement.get().setDescription(arrondissementDTO.getDescription());
		Arrondissement arrondissements = arrondissementRepository.save(arrondissement.get());
		return dtoArrMappers.fromArrondissement(arrondissements);
	}

	
	

}
