package com.example.springDiabetesCheck.api;

import com.example.springDiabetesCheck.domain.Launch;
import com.example.springDiabetesCheck.domain.Patient;
import com.example.springDiabetesCheck.service.LaunchService;
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
public class LaunchResource {
    private final LaunchService launchService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("/launchs")
    public ResponseEntity<List<Launch>> getLaunchs() {
        return ResponseEntity.ok().body(launchService.getLaunchs());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @PostMapping("/launch/save")
    public ResponseEntity<Launch> saveLaunch(@RequestBody Launch launch){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/launch/save").toUriString());
        return ResponseEntity.created(uri).body(launchService.saveLaunch(launch));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("launch/get/{id}")
    public Optional<Launch> getLaunchById(@PathVariable("id") Long id){
        return launchService.getLaunchById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("/launch/getByCoren/{coren}")
    public List<Optional<Launch>> getLaunchsByCoren(@PathVariable("coren") String coren) {
        return launchService.getLaunchsByCoren(coren);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @GetMapping("/launch/getByIdPatient/{id}")
    public List<Optional<Launch>> getLaunchsByIdPatient(@PathVariable("id") String id) {
        return launchService.getLaunchsByIdPatient(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @DeleteMapping("launch/delete/{id}")
    public void deleteLaunch(@PathVariable("id") Long id){
        launchService.deleteLaunch(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE', 'ROLE_DOCTOR')")
    @PutMapping("/launch/update/{id}")
    public Launch updateLaunchById(@RequestBody Launch launch, @PathVariable("id") Long id) {
        return launchService.updateLaunchById(launch, id);
    }
}
