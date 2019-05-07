package zumbi.Interfaces.IContador;

public interface IContador {
	public int melhorPergunta(String[][] sintomas);
	public int[] melhoresPerguntas(String[][] sintomas);
	
}

/* 
 * public int melhorPergunta(String[][] sintomas)
 * 
 * Parametros:
 * 		String[][] sintomas: Matriz de strings contendo os sintomas (t ou f) para cada paciente,
 * 		e seu respectivo diagnóstico.
 * 		
 * Retornos:
 * 		int contendo a posição do sintoma de maior interesse para uma pergunta, pode ser o sintoma
 * 		com a maior igualdade entre t e fs ou o de menor, dependendo do construtor escolhido na hora de
 * 		instanciar.
 * 
 * public int[] melhoresPerguntas(String[][] sintomas)
 * 
 * Paramêtros:
 * 		String[][] sintomas: Matriz de strings contendo os sintomas (t ou f) para cada paciente,
 * 		e seu respectivo diagnóstico.
 * 
 * Retornos:
 * 		Vetor de ints contendo as melhores perguntas a serem feitas pelo doutor,
 * 		ordenadas da melhor para a pior dependendo do construtor escolhido para para instanciá-lo.
 */
