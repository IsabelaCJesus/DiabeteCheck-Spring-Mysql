package com.example.springDiabetesCheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Launch {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String height;
    private String abdominalCircumference;
    private String coren;
    private Date date;
    private String schooling;
    private String idPatient;
    private String age;
    private String weight;
    private String income;
    private String comparativeResult;
    private String interventionResult;
    private String evolutionaryTime;
    private String triglycerides;
}