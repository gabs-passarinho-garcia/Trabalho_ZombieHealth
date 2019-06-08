import zumbi.Componentes.RedutorPossibilidades.*;
import zumbi.Interfaces.IRedutorPossibilidades.*;
/*imports necessarios para usar o componente*/

public class teste {

	public static void main(String[] args) {
		
		String[][] tabela = { {"t","f","f","t"} ,{"f","f","t","f"}, {"t","t","t","t"} };
		RedutorPossibilidades redutor = FabricaRedutor.criaRedutor();
		/* a fabrica possui metodo estatico para criar o redutor */
		
		System.out.println("Tamanho antes: " + tabela.length); /*note o tamanho antes de atualizar a tabela*/
		
		/* aqui escolhemos o sintoma 3 (coluna) e o paciente 1 (linha), que eh o unico que nao possui o sintoma */
		tabela = redutor.novaTabela(tabela, 3, "f");
		
		/*a linha que sobrou eh a linha 1, a unica que eh f para o primeiro sintoma*/
		System.out.println("Posicao [0][0]: " + tabela[0][0]);
		System.out.println("Tamanho depois: " + tabela.length);
	}

}
