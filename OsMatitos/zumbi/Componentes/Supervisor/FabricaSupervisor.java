package zumbi.Componentes.Supervisor;

import zumbi.Interfaces.ISupervisor.ISupervisor;

public class FabricaSupervisor {
	public static ISupervisor criarSupervisor() {
		return new Supervisor();
	}
	
	public static ISupervisor criarSupervisor(String path) {
		ISupervisor p = new Supervisor();
		p.desserializar(path);
		return p;
	}
}
