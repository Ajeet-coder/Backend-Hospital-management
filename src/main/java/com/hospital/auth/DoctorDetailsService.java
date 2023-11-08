package com.hospital.auth;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repo.DoctorRepo;

@Service
public class DoctorDetailsService implements UserDetailsService {

	@Autowired
	private DoctorRepo dRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    // Use the DoctorRepository to retrieve doctor information by username
	    Optional<Doctor> doctor = dRepo.findByName(username);

	    if (!doctor.isPresent()) {
	        throw new UsernameNotFoundException("Doctor not found with username: " + username);
	    }

	    // Create a UserDetails object based on doctor information
	    return new org.springframework.security.core.userdetails.User(
	        doctor.get().getName(),
	        doctor.get().getPassword(), // Typically a hashed password
	        // Add doctor's roles and authorities here (e.g., ROLE_DOCTOR)
	        new ArrayList<>()
	    );
	}


}
