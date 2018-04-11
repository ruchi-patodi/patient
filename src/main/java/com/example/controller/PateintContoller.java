/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Patient;
import com.example.repository.PatientRepository;

/**
 * @author rpatodi
 *
 */
@RestController
@RequestMapping("/api")
public class PateintContoller {

	@Autowired
	private PatientRepository patientRepository;

	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<String> savePatientData(){
		
		patientRepository.save(new Patient("Rory", "Glimore", "female", "whiteplains", "L_1234"));
		patientRepository.save(new Patient("Adam", "Johnson","male", "jersycity", "M_2341"));
		patientRepository.save(new Patient("Kim", "Smith","male", "longisland", "L_4744"));
		patientRepository.save(new Patient("David", "Williams","male", "boston", "B_4584"));
		patientRepository.save(new Patient("Peter", "Davis","male", "hartford", "H_7484"));

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value="/getallpatient",method=RequestMethod.GET)
	public ResponseEntity<List<Patient>> getAllPatient(){		

		List<Patient> listPatients = patientRepository.findAll();
		if(listPatients!=null) {			
			return new ResponseEntity<List<Patient>>(listPatients, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Patient>>(HttpStatus.NOT_FOUND);

		
	}

	
	
	

}
