package com.Project_UberBackend.entities;

import com.Project_UberBackend.DTOs.ArrondissementDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long commune_id;
private String description;
@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name ="arrondissement_id")
private Arrondissement arrondissement;
}
