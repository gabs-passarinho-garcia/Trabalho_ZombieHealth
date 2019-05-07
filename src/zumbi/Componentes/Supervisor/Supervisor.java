package zumbi.Interfaces.ISupervisor;

public interface ISupervisor {
	public void reportar(String diag, String doenca);
	public void gerarRelatorio();
	public void motivar();
}

/*
 * ISupervisor
 * Deve ser instanciado para funcionar 
 * -----------------------------------------------------------------------------
 * 
 * public void reportar(String diag, String doenca)
 * 
 * Argumentos:
 * 		String diag: nome da doença diagnosticada
 * 		String doenca: nome da doença verdadeira do zumbi
 * 
 * Retorno:
 * 		Nenhum
 * 
 * Comportamento:
 * 		Apenas armazena as informações de desempenho dos diagnósticos
 * 		informados.
 * 
 * 
 * ----------------------------------------------------------------------------
 * 
 * public void gerarRelatorio()
 * 
 * Argumentos:
 * 		Nenhum
 * 
 * Retorno:
 * 		Nenhum
 * 
 * Comportamento:
 * 		Imprime métricas de desempenho dos diagnósticos armazenados, tais como:
 * 			Acurácia
 * 			Precisão
 * 			Sensibilidade
 * 			Especifidade
 * 			F1 score
 * 
 * ----------------------------------------------------------------------------
 * 
 * public void motivar()
 * 
 * Argumentos:
 * 		Nenhum
 * 
 * Retorno:
 * 		Nenhum
 * 
 * Comportamento:
 * 		Imprime uma mensagem motivacional para o doutor
 * */
