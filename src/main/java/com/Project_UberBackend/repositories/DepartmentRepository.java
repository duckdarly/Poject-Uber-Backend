package com.Project_UberBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project_UberBackend.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
