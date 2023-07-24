package com.Project_UberBackend.DTOs;

import com.Project_UberBackend.entities.Arrondissement;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class CommuneDTO {
	private Long commune_id;
	private String description;
	private ArrondissementDTO arrondissementDTO;
	private Long arrondissement;
}
