package zumbi.Interfaces.IPatient;

import zumbi.Interfaces.ISupervisor.ISupervisor;

public interface IPatient extends IResponder, ITableProducerReceptacle {
	public String getCorrectAnswer();
	public void connect(ISupervisor observer);
	public void notificar(String answer);
}
