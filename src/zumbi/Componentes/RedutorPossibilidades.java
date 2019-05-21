package zumbi.Componentes;

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