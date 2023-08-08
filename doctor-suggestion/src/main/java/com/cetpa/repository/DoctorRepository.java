package com.cetpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.model.Doctor;

public interface DoctorRepository extends JpaRepository <Doctor ,Integer>{

	
	List<Doctor> findByCity(String city);
	
	@Query("select d from Doctor d where speciality=:x and city=:y")
	List<Doctor> findBySpeciality(@Param("x")String speciality,@Param("y")String city);

}
