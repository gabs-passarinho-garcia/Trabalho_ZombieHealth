package zumbi.Componentes.Supervisor;
import zumbi.Interfaces.ISupervisor.ISupervisor;

public class Teste {

	public static void main(String[] args) {
		
		ISupervisor a = new Supervisor();
		a.reportar("gripe", "gripe");
		a.reportar("gripe", "gripe");
		a.reportar("gripe", "malaria");
		a.reportar("gripe", "malaria");
		a.reportar("malaria", "gripe");
		a.reportar("febre", "ulcera");
		a.reportar("vomito", "gripe");
		a.reportar("vomito", "gripe");
		
		((Supervisor)a).imprimir();
	}

}
