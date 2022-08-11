package com.example.springDiabetesCheck.repository;

import com.example.springDiabetesCheck.domain.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaunchRepository extends JpaRepository<Launch, Long> {
    Optional<Launch> findById(Long id);
    List<Optional<Launch>> findByCoren(String coren);
    List<Optional<Launch>> findByIdPatient(String id);
}

