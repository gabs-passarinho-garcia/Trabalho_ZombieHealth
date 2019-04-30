package zumbi.Interfaces;

public interface Icontador {
	public int conta_porcentagem(String[][] sintomas);
	
}

/* 
 * public int conta_porcentagem(String[][] sintomas)
 * 
 * Parametros:
 * 		String[][] sintomas: Matriz de strings contendo os sintomas (t ou f) para cada paciente,
 * 		e seu respectivo diagnóstico.
 * 		
 * Retornos:
 * 		int contendo a posição do sintoma de maior interesse para uma pergunta, pode ser o sintoma
 * 		com a maior igualdade entre t e fs ou o de menor, dependendo do construtor escolhido na hora de
 * 		instanciar.
 */
