package com.example.springDiabetesCheck.repository;

import com.example.springDiabetesCheck.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Optional<Patient> findById(Long id);
}
