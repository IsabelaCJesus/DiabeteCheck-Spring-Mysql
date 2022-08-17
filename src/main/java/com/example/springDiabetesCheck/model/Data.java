package com.example.springDiabetesCheck.model;

import lombok.Getter;

@lombok.Data
@Getter
public class Data {
    
    private int age;
    private float height;
    private float weight;
    private float triglycerides;
    private float evolutionaryTime;
    private float abdominalCircumference;
    private float income;
    private float schooling;
}
