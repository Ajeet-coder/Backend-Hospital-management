package com.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repo.DoctorRepo;
import com.hospital.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService {
	
	
	
	@Autowired
	private DoctorRepo drepo;

	@Override
	public Doctor registerDoctor(Doctor doctor) {
		
		UUID id=UUID.randomUUID();
		Doctor data = new Doctor(doctor.getName(), doctor.getSpecialty(), doctor.getContactDetails(),id.toString());
		drepo.save(data);
		return doctor;
	}

	@Override
	public List<Doctor> getAllDoctors() {
	List<Doctor> doctors=	drepo.findAll();
		return doctors;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor deleteDoctor(Doctor doctor) {
		
		drepo.delete(doctor);
		return doctor;
	}

	@Override
	public Doctor getDoctorById(String id) {
		
		List<Doctor> doctors= drepo.findAll();
		
		
		for(Doctor  doctor: doctors) {
			if(doctor.getId().equals(id)) return doctor;
		}
		return null;
		
	}

}
