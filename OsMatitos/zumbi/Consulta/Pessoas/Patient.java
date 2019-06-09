package zumbi.Consulta.Pessoas;

import zumbi.Interfaces.IDataSet.ITableProducer;
import zumbi.Interfaces.IPatient.IPatient;
import zumbi.Interfaces.ISupervisor.ISupervisor;

public class Patient implements IPatient {
	private int patientN = 0;

	private ITableProducer producer;

	private String attributes[];
	private String patientInstance[];
	private ISupervisor observer;
	private String correctAnswer;
	
	public void connect(ITableProducer producer) {
		
		this.producer = producer;
		

		attributes = producer.requestAttributes();
		String instances[][] = producer.requestInstances();

		patientN = (int) (Math.random() * instances.length);
		patientInstance = instances[patientN];

		System.out.println("Patient selected: " + patientN);
		System.out.println("Patient's disease: " + patientInstance[attributes.length - 1]);
		
	}

	public String ask(String question) {
		String result = "unknown";

		for (int a = 0; a < attributes.length - 1; a++)
			if (question.equalsIgnoreCase(attributes[a]))
				result = (patientInstance[a].equals("t")) ? "yes" : "no";

		return result;
	}

	public boolean finalAnswer(String answer) {
		boolean result = false;
		if (answer.equalsIgnoreCase(patientInstance[attributes.length - 1]))
			result = true;
		
		if (result == true)
			correctAnswer = "correct";
		else
			correctAnswer = "incorrect";
		
		notificar(answer);
		
		return result;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void connect(ISupervisor observer) {
		this.observer = observer;
	}
	
	public void notificar(String answer) {
		observer.reportar(answer, patientInstance[attributes.length - 1]);
	}
}
