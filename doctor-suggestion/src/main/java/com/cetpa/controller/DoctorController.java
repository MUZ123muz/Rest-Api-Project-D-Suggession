package com.cetpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cetpa.model.Doctor;
import com.cetpa.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired private DoctorService service;
	
	@PostMapping("create")
	public ResponseEntity<Doctor> createRequestEntity(@Valid @RequestBody Doctor d)
	{
		Doctor dr=service.saveDoctor(d);
		return ResponseEntity.status(HttpStatus.CREATED).body(dr);
	}
	
	@GetMapping("show/{did}")
	public ResponseEntity<Doctor> getDoctorDetail(@PathVariable int did)
	{
		Doctor d=service.getDetails(did);
		
		return ResponseEntity.ok(d);
		
	}
	
	@DeleteMapping("delete/{did}")
	public ResponseEntity<Doctor> deleteDoctorDetail(@PathVariable int did)
	{
		Doctor d=service.getDetails(did);
		service.deleteDoctor(did);
		
		return ResponseEntity.ok(d);
		
	}
}
