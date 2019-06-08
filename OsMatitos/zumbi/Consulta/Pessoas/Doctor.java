package zumbi.Consulta.Pessoas;

import zumbi.Interfaces.IDataSet.ITableProducer;
import zumbi.Interfaces.IDoctor.IDoctor;
import zumbi.Interfaces.IPatient.IResponder;

public class Doctor implements IDoctor {
	private int patientN = 0;
	private boolean diagnosed = false;

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
		boolean possibilities[] = new boolean[instances.length];// pacientes possíveis
		
		for (int i = 0; i < possibilities.length; i++)// todos têm potencial 
			possibilities[i] = true;

		for (int a = 0; a < attributes.length - 1; a++) {
			String answer = responder.ask(attributes[a]);
			System.out.println("Question: " + answer);

			possibilities = checkPossibilities(possibilities, instances, a, answer);

			if (diagnosed)
				break;
		}

		patientN = getPatient(possibilities);

		System.out.println("Disease guess: " + instances[patientN][attributes.length - 1]);
		boolean result = responder.finalAnswer(instances[patientN][attributes.length - 1]);
		System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
	}

	private boolean[] checkPossibilities(boolean possibilities[], String instances[][], int a, String answer) {
		int cont = 0;

		if (answer.equalsIgnoreCase("yes"))// converter resposta
			answer = "t";
		else
			answer = "f";

		for (int i = 0; i < instances.length; i++) {
			if (!possibilities[i])// ignorar o que já foi eliminado
				continue;

			possibilities[i] = instances[i][a].equals(answer);
		}

		for (int i = 0; i < instances.length; i++) {
			if (possibilities[i])
				cont++;
		}

		if (cont <= 1)// já pode parar
			diagnosed = true;

		return possibilities;
	}

	private int getPatient(boolean possibilities[]) {
		int i, returnValue = 0;

		for (i = 0; i < possibilities.length; i++) {// Retornar o primeiro paciente que não foi eliminado,
													// não resolve quando há mais de uma possibilidade
			if (possibilities[i]) {
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}
}
