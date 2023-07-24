package com.Project_UberBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project_UberBackend.entities.Arrondissement;
import com.Project_UberBackend.services.ArrondissementService;

public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long>{

}
