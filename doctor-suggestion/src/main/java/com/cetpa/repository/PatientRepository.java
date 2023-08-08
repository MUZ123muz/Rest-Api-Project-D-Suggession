package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	
	
	@Query("select p.symptoms from Patient p where pid=:id")
	public String getSymptoms(@Param("id") int pid);
}
