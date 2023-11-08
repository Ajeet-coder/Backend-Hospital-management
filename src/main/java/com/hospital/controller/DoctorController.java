package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.auth.DoctorDetailsService;
import com.hospital.dto.DoctorLoginRequest;
import com.hospital.entity.Doctor;
import com.hospital.repo.DoctorRepo;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	
	@Autowired
	private DoctorService dService;
	
	@Autowired
	private DoctorRepo drepo;
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	
//	@PostMapping("/register")
//	public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor){
//		
//		System.out.println(doctor.toString());
//		dService.registerDoctor(doctor);
//		
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body("Done!");
//		
//	}
	
	//
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		
		List<Doctor> doctors= dService.getAllDoctors();
		
		return ResponseEntity.ok(doctors);
		
		
	}
	
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Doctor> getDoctorByID(@PathVariable String id) {
		
		System.out.println("Pathhhhh"+id);
		
		Doctor doctor = dService.getDoctorById(id);
		
		return ResponseEntity.ok(doctor);
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable String  id){
		System.out.println("iiiiid"+id);
		Doctor doctor = dService.getDoctorById(id);
		
		System.out.println(("Delete Doctor"+doctor));
		dService.deleteDoctor(doctor);
		
		return ResponseEntity.ok(doctor);
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor) {
        // Check if the username is already taken
        if (drepo.findByName(doctor.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }

        drepo.save(doctor);
        return ResponseEntity.ok("Doctor registration successful.");
    }
}
