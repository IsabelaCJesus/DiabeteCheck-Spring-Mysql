package com.example.springDiabetesCheck.api;
import com.example.springDiabetesCheck.domain.*;
import com.example.springDiabetesCheck.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientResource {
    private final PatientService patientService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @PostMapping("/patient/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/patient/save").toUriString());
        return ResponseEntity.created(uri).body(patientService.savePatient(patient));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("patient/get/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @DeleteMapping("patient/delete/{id}")
    public void deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @PutMapping("/patient/update/{id}")
    public Patient updatePatientById(@RequestBody Patient patient, @PathVariable("id") Long id) {
        return patientService.updatePatientById(patient, id);
    }
}