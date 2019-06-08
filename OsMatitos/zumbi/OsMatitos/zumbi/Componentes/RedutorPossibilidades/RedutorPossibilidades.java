package zumbi.Componentes.RedutorPossibilidades;

import zumbi.Interfaces.IRedutorPossibilidades.*;

public class RedutorPossibilidades implements IRedutorPossibilidades {
	public String[][] novaTabela(String[][] tabela, int sintoma, String resposta) {
		int linhas = 0;
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][sintoma].equalsIgnoreCase(resposta))
				linhas++;
		}
		String[][] newTable = new String[linhas][tabela[0].length];
		int j = 0;
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][sintoma].equalsIgnoreCase(resposta))
			{
				newTable[j] = tabela[i];
				j++;
			}
		}
		return newTable;
	}
}

/*
Exemplo de uso:
	Abaixo, a "tabelaPacientes" eh a tabela de instancias, "n" corresponde a posicao do paciente, 
"pos" se refere a coluna da pergunta que deseja ser feita e tabelaPacientes[n][pos] eh a "resposta" 
do paciente (t ou f).
	Pode-se obter a "resposta" do paciente por outro metodo e passado como referencia no lugar de
"tabelaPacientes[n][pos]"
===============================================================================================

	RedutorPossibilidades redutor = new RedutorPossibilidades();
	tabelaPacientes = redutor.novaTabela(tabelaPacientes, pos, tabelaPacientes[n][pos]);
	
===============================================================================================
*/
