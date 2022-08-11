package com.example.springDiabetesCheck.controller;

import com.example.springDiabetesCheck.model.Dados;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diabetesComparative")
public class DiabetesControllerComparativeGroup {

    @PostMapping
    public Double calcularComparativeGroup(@RequestBody Dados dados){
        SimuladorDiabetesComparativeGroup program = new SimuladorDiabetesComparativeGroup();
        double indiceG = program.executar(dados);
        return indiceG;
    }
}
