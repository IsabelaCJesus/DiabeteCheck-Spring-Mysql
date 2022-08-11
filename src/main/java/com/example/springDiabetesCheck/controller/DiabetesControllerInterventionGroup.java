package com.example.springDiabetesCheck.controller;

import com.example.springDiabetesCheck.model.Dados;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diabetesIntervention")
public class DiabetesControllerInterventionGroup {

    @PostMapping
    public Double calcularInterventionGroup(@RequestBody Dados dados){
        SimuladorDiabetesInterventionGroup program = new SimuladorDiabetesInterventionGroup();
        double indiceG = program.executar(dados);
        return indiceG;
    }
}
