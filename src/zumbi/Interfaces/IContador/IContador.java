package zumbi.Interfaces.IContador;

import java.io.*;

public interface IContador {
	public int melhorPergunta(String[][] sintomas);
	public void serializa(FileWriter arquivo);
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
 * public void serializa(FileWriter arquivo)
 * 
 * Parametros:
 * 		FileWriter arquivo: objeto FileWriter para o objeto serializar-se em um arquivo.
 * 
 * Retornos:
 * 		Vazio.
 */
