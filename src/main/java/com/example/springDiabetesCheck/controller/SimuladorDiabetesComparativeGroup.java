package com.example.springDiabetesCheck.controller;

import com.example.springDiabetesCheck.model.Data;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import java.lang.Math;

public class SimuladorDiabetesComparativeGroup {

	public double executar(Data dados) {
		String nomeArq = "diabetesFuzzyComparationGroup.fcl";
		FIS fis = FIS.load(nomeArq, true);
		
		if (fis == null) {
			System.err.println("Nao foi possivel abrir o arquivo '" + nomeArq + "'");
			System.exit(1);
		}

		// Obter o bloco padrão de função
		FunctionBlock fb = fis.getFunctionBlock(null);

        Double imc = dados.getWeight() / Math.pow(dados.getHeight(),2);

		fb.setVariable("idade", dados.getAge());
		fb.setVariable("triglicerideos", dados.getTriglycerides());
		fb.setVariable("tempoEvolutivo", dados.getEvolutionaryTime());
		fb.setVariable("IMC", imc);
		fb.setVariable("circunferenciaAbdominal", dados.getAbdominalCircumference());
		fb.setVariable("renda", dados.getIncome());
		fb.setVariable("escolaridade", dados.getSchooling());

		// Evaluate
		fb.evaluate();

		// Mostrar o gráfico da variável de saída
		fb.getVariable("diabetes").defuzzify();

		// Imprime o conjunto de regras
		//System.out.println(fb);
		//System.out.println("Diabetes: " + fb.getVariable("diabetes").getValue());

        return fb.getVariable("diabetes").getValue();
	}
}
