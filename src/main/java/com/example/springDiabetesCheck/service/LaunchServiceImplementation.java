package com.example.springDiabetesCheck.service;

import com.example.springDiabetesCheck.domain.Launch;
import com.example.springDiabetesCheck.domain.Patient;
import com.example.springDiabetesCheck.repository.LaunchRepository;
import com.example.springDiabetesCheck.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LaunchServiceImplementation implements LaunchService {
    private final LaunchRepository launchRepository;

    @Override
    public List<Launch> getLaunchs() {
        log.info("Buscando todos os lancamentos");
        return launchRepository.findAll();
    }
    @Override
    public Launch saveLaunch(Launch launch) {
        log.info("Salvando novo lancamento {} no banco de dados", launch.getId());
        return launchRepository.save(launch);
    }

    @Override
    public Optional<Launch> getLaunchById(Long id) {
        log.info("Buscando lancamento {}", id);
        return launchRepository.findById(id);
    }

    @Override
    public void deleteLaunch(Long id){
        log.info("Deletando lancamento {} do banco de dados", id);
        if(launchRepository.existsById(id)){
            launchRepository.deleteById(id);
        }
    }

    @Override
    public Launch updateLaunchById(Launch launch, Long id){
        Optional<Launch> op = launchRepository.findById(id);
        if(op.isPresent()) {
            Launch obj = op.get();
            if (obj.getHeight() != launch.getHeight()) {
                obj.setHeight(launch.getHeight());
            }
            if (obj.getAbdominalCircumference() != launch.getAbdominalCircumference()) {
                obj.setAbdominalCircumference(launch.getAbdominalCircumference());
            }
            if (obj.getCoren() != launch.getCoren()) {
                obj.setCoren(launch.getCoren());
            }
            if (obj.getDate() != launch.getDate()) {
                obj.setDate(launch.getDate());
            }
            if (obj.getSchooling() != launch.getSchooling()) {
                obj.setSchooling(launch.getSchooling());
            }
            if (obj.getIdPatient() != launch.getIdPatient()) {
                obj.setIdPatient(launch.getIdPatient());
            }
            if (obj.getAge() != launch.getAge()) {
                obj.setAge(launch.getAge());
            }
            if (obj.getWeight() != launch.getWeight()) {
                obj.setWeight(launch.getWeight());
            }
            if (obj.getIncome() != launch.getIncome()) {
                obj.setIncome(launch.getIncome());
            }
            if (obj.getComparativeResult() != launch.getComparativeResult()) {
                obj.setComparativeResult(launch.getComparativeResult());
            }
            if (obj.getInterventionResult() != launch.getInterventionResult()) {
                obj.setInterventionResult(launch.getInterventionResult());
            }
            if (obj.getEvolutionaryTime() != launch.getEvolutionaryTime()) {
                obj.setEvolutionaryTime(launch.getEvolutionaryTime());
            }
            if (obj.getTriglycerides() != launch.getTriglycerides()) {
                obj.setTriglycerides(launch.getTriglycerides());
            }
            launchRepository.save(obj);
            return obj;
        }
        return null;
    }

    @Override
    public List<Optional<Launch>> getLaunchsByCoren(String coren){
        return launchRepository.findByCoren(coren);
    }
    @Override
    public List<Optional<Launch>> getLaunchsByIdPatient(String id){
        return launchRepository.findByIdPatient(id);
    }
}

