package com.example.springDiabetesCheck.service;

import com.example.springDiabetesCheck.domain.Patient;
import com.example.springDiabetesCheck.domain.User;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getPatients();
    Patient savePatient(Patient patient);
    Optional<Patient> getPatientById(Long id);
    void deletePatient(Long id);
    Patient updatePatientById(Patient patient, Long id);
}
