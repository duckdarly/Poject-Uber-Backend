package com.Project_UberBackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project_UberBackend.DTOs.ArrondissementDTO;
import com.Project_UberBackend.exceptions.ArrondissementNotFound;
import com.Project_UberBackend.exceptions.DepartmentNotFoundException;
import com.Project_UberBackend.services.ArrondissementService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ArrondissementController {
	private ArrondissementService arrondissementService;;
	@PostMapping("/arrondissements")
	public ArrondissementDTO saveArrondissement(@RequestBody ArrondissementDTO arrondissementDTO) throws DepartmentNotFoundException {
		return arrondissementService.saveArrondissement(arrondissementDTO);
	}
	@GetMapping("/arrondissements")
	public List<ArrondissementDTO> getAllArrondissement(){
		return arrondissementService.listArrondissement();
	}
	@GetMapping("/arrondissements/{id}")
	public ArrondissementDTO getArrondissement(@PathVariable(name="id") Long id) throws ArrondissementNotFound {
		return arrondissementService.getArrondissement(id);
	}
	@DeleteMapping("/arrondissements/{id}")
	public void deleteArrondissement(@PathVariable(name="id") Long arrondissement_id) {
		arrondissementService.deleteArrondissement(arrondissement_id);
	}
	
	@PutMapping("/arrondissements/{id}")
	public ArrondissementDTO updateArrondissement(@PathVariable(name="id") Long id, @RequestBody ArrondissementDTO arrondissementDTO) throws DepartmentNotFoundException {
		return arrondissementService.updateArrondissement(arrondissementDTO, id);
	}

}
