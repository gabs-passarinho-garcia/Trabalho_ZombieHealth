package zumbi.Interfaces;

public interface IRedutorPossibilidades {
	public String[][] novaTabela(String[][] tabela, int sintoma, String resposta);
}

/* Parâmetros: 
-String[][] tabela: tabela de pacientes possíveis do doutor
-int sintoma: indica a posição na tabela do sintoma a ser analisado
-String resposta: indica se o paciente tem ou não o sintoma (“t”, “f”, “yes”, “no”)
   Retorno:
String[][] novaTabela: Tabela atualizada sem os zumbis que não se enquadram com a resposta obtida */
