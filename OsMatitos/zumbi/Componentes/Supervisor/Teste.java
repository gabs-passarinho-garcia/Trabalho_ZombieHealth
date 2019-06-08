package zumbi.Componentes.Supervisor;
import zumbi.Interfaces.ISupervisor.ISupervisor;

public class Teste {

	public static void main(String[] args) {
		
		ISupervisor a = FabricaSupervisor.criarSupervisor();
		a.reportar("gripe", "gripe");
		a.reportar("gripe", "gripe");
		a.reportar("gripe", "malaria");
		a.reportar("gripe", "malaria");
		a.reportar("malaria", "gripe");
		a.reportar("febre", "ulcera");
		a.reportar("vomito", "gripe");
		a.reportar("vomito", "gripe");
		
		((Supervisor)a).imprimir();
		
		System.out.print(a.strRelatorio());
		a.serializar("");
		ISupervisor b = FabricaSupervisor.criarSupervisor("");
		((Supervisor)b).imprimir();
		b.gerarRelatorio();
		
		b.reset();
		b.reportar("vomito", "gripe");
		((Supervisor)b).imprimir();
		System.out.println(b.getAcuracia());
		b.motivar();
		System.out.println(b.strMotivar());
	}

}
