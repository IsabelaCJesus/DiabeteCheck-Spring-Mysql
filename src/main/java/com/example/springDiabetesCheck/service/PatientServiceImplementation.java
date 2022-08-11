package com.example.springDiabetesCheck.service;

import com.example.springDiabetesCheck.domain.*;
import com.example.springDiabetesCheck.repository.*;
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
public class PatientServiceImplementation implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getPatients() {
        log.info("Buscando todos os pacientes");
        return patientRepository.findAll();
    }
    @Override
    public Patient savePatient(Patient patient) {
        log.info("Salvando novo paciente {} no banco de dados", patient.getName());
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        log.info("Buscando paciente {}", id);
        return patientRepository.findById(id);
    }

    @Override
    public void deletePatient(Long id){
        log.info("Deletando paciente {} do banco de dados", id);
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }
    }
    @Override
    public Patient updatePatientById(Patient patient, Long id){
            Optional<Patient> op = patientRepository.findById(id);
            if(op.isPresent()) {
                Patient obj = op.get();
                if (obj.getName() != patient.getName()) {
                    obj.setName(patient.getName());
                }
                if (obj.getCoren() != patient.getCoren()) {
                    obj.setCoren(patient.getCoren());
                }
                if (obj.getBirthDate() != patient.getBirthDate()) {
                    obj.setBirthDate(patient.getBirthDate());
                }
                if (obj.getEmail() != patient.getEmail()) {
                    obj.setEmail(patient.getEmail());
                }
                if (obj.getPhoneNumber() != patient.getPhoneNumber()) {
                    obj.setPhoneNumber(patient.getPhoneNumber());
                }
                patientRepository.save(obj);
                return obj;
            }
            return null;
        }
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Salvando novo usuário {} no banco de dados", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(String name, Long id){
        Optional<User> op = userRepository.findById(id);
        if(op.isPresent()) {
            User obj = op.get();
            if (obj.getName() != name) {
                obj.setName(name);
            }
            userRepository.save(obj);
            return obj;
        }
        return null;
    }



    @Override
    public Role saveRole(Role role) {
        log.info("Salvando novo papel {} no banco de dados", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRouleToUser(String username, String roleName) {
        log.info("Adicionando papel {} ao usuario {}", roleName, username);
        User user = userRepository.findByUsername((username));
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Buscando usuario {}", username);
        return userRepository.findByUsername(username);
    }*/
