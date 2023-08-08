package com.cetpa.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.exception.RecordNotFoundException;
import com.cetpa.model.Doctor;
import com.cetpa.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired  private DoctorRepository repo;

	public Doctor saveDoctor(@Valid Doctor d) {
		
		return repo.save(d);
	}

	public Doctor getDetails(int did) {
		
		return repo.findById(did).orElseThrow(()->new RecordNotFoundException("Doctor with id "+did+" not found"));
	}

	public void deleteDoctor(int did) {
		repo.deleteById(did);
		
	}

}
