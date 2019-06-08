package zumbi.Interfaces.ISupervisor;

public interface ISupervisor {
	public void reportar(String diag, String doenca);
	public void gerarRelatorio();
	public String strRelatorio();
	public void motivar();
	public String strMotivar();
	public void serializar(String path);
	public void desserializar(String path);
	public double getAcuracia();
	public void reset();
}

/*
 * ISupervisor
 * Deve ser instanciado para funcionar 
 * -----------------------------------------------------------------------------
 * 
 * public void reportar(String diag, String doenca)
 * 
 * Argumentos:
 * 		String diag: nome da doen�a diagnosticada
 * 		String doenca: nome da doen�a verdadeira do zumbi
 * 
 * Retorno:
 * 		Nenhum
 * 
 * Comportamento:
 * 		Apenas armazena as informa��es de desempenho dos diagn�sticos
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
 * 		Imprime m�tricas de desempenho dos diagn�sticos armazenados, tais como:
 * 			Acur�cia
 * 			Precis�o
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
