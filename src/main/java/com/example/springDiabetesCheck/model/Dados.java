package com.example.springDiabetesCheck.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Dados {
    
    private int idade;
    private float altura;
    private float peso;
    private float triglicerideos;
    private float tempoEvolutivo;
    private float circunferenciaAbdominal;
    private float renda;
    private float escolaridade;
}
