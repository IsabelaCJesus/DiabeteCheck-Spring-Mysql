package com.example.springDiabetesCheck.service;
import java.util.List;
import java.util.Optional;

import com.example.springDiabetesCheck.domain.Launch;
import org.springframework.http.ResponseEntity;

public interface LaunchService {
    List<Launch> getLaunchs();
    Launch saveLaunch(Launch launch);
    Optional<Launch> getLaunchById(Long id);
    void deleteLaunch(Long id);
    Launch updateLaunchById(Launch launch, Long id);
    List<Optional<Launch>> getLaunchsByCoren(String coren);

    List<Optional<Launch>> getLaunchsByIdPatient(String id);
}
