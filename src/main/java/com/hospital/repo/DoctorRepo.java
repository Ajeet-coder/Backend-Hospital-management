package com.hospital.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

	Optional<Doctor> findByName(String username);
}
