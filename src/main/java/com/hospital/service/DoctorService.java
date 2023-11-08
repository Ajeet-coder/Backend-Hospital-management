package com.hospital.service;

import java.util.List;

import com.hospital.entity.Doctor;

public interface DoctorService {
	
	
	public Doctor registerDoctor(Doctor doctor);
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(String id);
	
	public Doctor updateDoctor(Doctor doctor);
	public Doctor deleteDoctor(Doctor doctor);

}
