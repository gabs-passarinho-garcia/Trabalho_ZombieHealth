package zumbi.Consulta.Pessoas;

import zumbi.Classes.ContaSuperFactory.ContaSuperFactory;
import zumbi.Componentes.RedutorPossibilidades.FabricaRedutor;
import zumbi.Interfaces.IContaFactory.IContaFactory;
import zumbi.Interfaces.IContador.IContador;
import zumbi.Interfaces.IDataSet.ITableProducer;
import zumbi.Interfaces.IDoctor.IDoctor;
import zumbi.Interfaces.IPatient.IResponder;
import zumbi.Interfaces.IRedutorPossibilidades.IRedutorPossibilidades;

public class Doctor implements IDoctor {
	private boolean diagnosed = false; // foi diagnosticado ou nao
	private String diagnose = null; // qual eh o diagnostico

	private ITableProducer producer;
	private IResponder responder;

	
	public void connect(ITableProducer producer) {
		this.producer = producer;
	}

	public void connect(IResponder responder) {
		this.responder = responder;
	}

	public void startInterview() {
		String attributes[] = producer.requestAttributes();
		String instances[][] = producer.requestInstances();
		String[][] copia = copiaMatriz(instances);
		IContaFactory melhorFactory = ContaSuperFactory.criaFabrica();
		IContador question = melhorFactory.criaMelhorPergunta();
		IRedutorPossibilidades redutor = FabricaRedutor.criaRedutor();
		
		diagnosed = false;
		diagnose = null;
		for (int i = 0; i < attributes.length - 1; i++) { // numero de iteracoes eh menor que o numero de sintomas
			int melhorN = question.melhorPergunta(copia);
			String answer = responder.ask(attributes[melhorN]);
			
			if (answer.equalsIgnoreCase("yes")) // converter resposta
				answer = "t";
			else
				answer = "f";
			
			copia = redutor.novaTabela(copia, melhorN, answer); // atualiza a tabela
			diagnosed = onePossibility(copia, attributes.length - 1); 
			
			if (diagnosed) // verifica se ja encontrou solucao
				break;
		}
		
		diagnose = getPatient(copia, attributes.length - 1); 

		System.out.println("Disease guess: " + diagnose);
		boolean result = responder.finalAnswer(diagnose);
		System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
	}

	public boolean onePossibility(String matriz[][], int n) { 
		boolean onlyOne = true;
		String firstDisease = null;
		
		if (matriz != null) {
			firstDisease = matriz[0][n];
			for (int i = 1; i < matriz.length; i++)
				if (firstDisease.equalsIgnoreCase(matriz[i][n]))
					continue;
				else {
					onlyOne = false;
					break;
				}
		}
		return onlyOne;
	}

	public String getPatient(String matriz[][], int n) {
		String returnValue = matriz[0][n];
		return returnValue;
	}
	
	public String getDiagnose() {
		return diagnose;
	}
	
	private static String[][] copiaMatriz(String[][] original) {
		String[][] copia = new String[original.length][original[0].length];
		for (int i = 0; i < original.length; i++)
			for (int j = 0; j < original[0].length; j++) 
				copia[i][j] = original[i][j];
		return copia;
	}
	
}
