package com.cetpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.cetpa.model.Doctor;
import com.cetpa.model.Patient;

import com.cetpa.service.PatientService;


@RestController
@RequestMapping("patient")
public class PatientController {

	
	@Autowired private PatientService service;
	
	@PostMapping("create")
	public ResponseEntity<Patient> savePatientMethod(@Valid @RequestBody Patient p)
	{
		Patient pt=service.savePatient(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(pt);
	}
	
   @GetMapping("doctor-suggession/{pid}")
   public ResponseEntity<List<Doctor>> getDoctorSuggession(@PathVariable int pid)
   {
	   List<Doctor> list=service.getDoctorList(pid);
	 	 return ResponseEntity.ok(list);
   }
 
}
