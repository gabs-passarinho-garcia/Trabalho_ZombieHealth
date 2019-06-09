package zumbi.Interfaces.IDoctor;

import zumbi.Interfaces.IPatient.ITableProducerReceptacle;

public interface IDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle{
	
	public boolean onePossibility(String matriz[][], int n);
	public String getPatient(String matriz[][], int n);
	public String getDiagnose();
	
}
