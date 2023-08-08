package com.cetpa.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.exception.RecordNotFoundException;
import com.cetpa.model.Doctor;
import com.cetpa.model.Patient;
import com.cetpa.repository.DoctorRepository;
import com.cetpa.repository.PatientRepository;
import com.cetpa.suggession.Speciality;

@Service
public class PatientService {
	
	@Autowired  private DoctorRepository drepo;
	@Autowired private PatientRepository repo;

	
	public Patient savePatient(@Valid Patient p) {
		
		return repo.save(p);
	}


	public String getSuggession(int pid) {
		
		String sym=repo.getSymptoms(pid);
		
		  if(sym==null)
		   
		   throw new RecordNotFoundException("patient id "+pid+" does not exist");
		   
		   return sym;	
		
	}


	public Patient getPatient(int pid) {
		
		Patient p=repo. findById(pid).orElseThrow(()->new RecordNotFoundException("Patient with id "+pid+" does not exist"));
		return p;
	}


	public List<Doctor> getDoctorList(int pid) {
		
		Patient pat=repo. findById(pid).orElseThrow(()->new RecordNotFoundException("Patient with id "+pid+" does not exist"));
		
		        String pcity=pat.getCity();
		  List<Doctor> list1=drepo.findByCity(pcity);
		  if(list1.isEmpty())
		  {
			  throw new RecordNotFoundException("we are still waiting to expand  your location");
		  }
		   String sym=pat.getSymptoms();
		   String spc=Speciality.map.get(sym);
		   List<Doctor> list2=drepo.findBySpeciality(spc,pcity);
     //  List<Doctor> list3=list2.stream().filter(d->d.getCity().equals(pcity)).collect(Collectors.toList());
           
           
           
          if(list2.isEmpty())
          {
        	  throw new RecordNotFoundException("there is no doctor present at your location");
          }
		return list2;
	}


	
}
