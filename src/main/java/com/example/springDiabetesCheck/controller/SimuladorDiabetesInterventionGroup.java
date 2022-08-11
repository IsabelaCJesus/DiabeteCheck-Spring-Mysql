package com.example.springDiabetesCheck.controller;

import com.example.springDiabetesCheck.model.Dados;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import java.lang.Math;

public class SimuladorDiabetesInterventionGroup {

	public double executar(Dados dados) {
		String nomeArq = "diabetesFuzzy.fcl";
		FIS fis = FIS.load(nomeArq, true);
		
		if (fis == null) {
			System.err.println("Nao foi possivel abrir o arquivo '" + nomeArq + "'");
			System.exit(1);
		}

		// Obter o bloco padrão de função
		FunctionBlock fb = fis.getFunctionBlock(null);

        Double imc = dados.getPeso() / Math.pow(dados.getAltura(),2);

		fb.setVariable("idade", dados.getIdade());
		fb.setVariable("triglicerideos", dados.getTriglicerideos());
		fb.setVariable("tempoEvolutivo", dados.getTempoEvolutivo());
		fb.setVariable("IMC", imc);
		fb.setVariable("circunferenciaAbdominal", dados.getCircunferenciaAbdominal());
		fb.setVariable("renda", dados.getRenda());
		fb.setVariable("escolaridade", dados.getEscolaridade());

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