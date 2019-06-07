package areaTeste;

//Pacotes necessarios!!
import zumbi.Componentes.Supervisor.*;
import zumbi.Interfaces.ISupervisor.*;

public class TesteSupervisor {

	public static void main(String[] args) {
		
		//Factory method para criar supervisor
		ISupervisor sup = FabricaSupervisor.criarSupervisor();
		
		
		//strMotivar() retorna uma string com uma frase motivacional
		System.out.println(sup.strMotivar());
		
		
		//motivar() imprime a frase por conta propria
		sup.motivar();
		
		
		//a primeira string é o diagnostico do doutor, o segundo eh a doenca verdadeira
		sup.reportar("gripe", "gripe");
		sup.reportar("gripe", "virose");
		sup.reportar("cancer", "cancer");
		sup.reportar("cancer", "diarreia");
		
		
		//o metodo retorna uma String com o relatorio correto
		String aux = sup.strRelatorio();
		
		//agora, o mesmo relatorio eh impresso pelo metodo
		sup.gerarRelatorio();
		
		
		//getAcuracia() retorna um double com a acuracia dos diagnostico ate entao
		System.out.println(sup.getAcuracia());
		
		
		//o supervisor eh serializado no diretorio da pasta informado, no caso, irá para
		//a raiz do projeto
		sup.serializar(""); //poderia ser "home/ra000000/", por exemplo
		
		
		//O Supervisor foi criado e desserializado pela fabrica (opcao 1)
		//a String eh o diretorio da pasta onde foi serializado
		ISupervisor sup2 = FabricaSupervisor.criarSupervisor("");
		
		
		//Segunda forma de desserializar o Supervisor por DAO
		ISupervisor sup3 = FabricaSupervisor.criarSupervisor();
		sup3.desserializar("");
		
		
		sup3.gerarRelatorio();
		
		
		//tudo o que foi reportado para o supervisor foi esquecido ;-;
		sup.reset();
	}

}
