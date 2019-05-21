package zumbi.Componentes;

import zumbi.Interfaces.IContador.IContador;
import java.lang.Math;

public class ContaMetade implements IContador {
	public int melhorPergunta(String[][] sintomas) {
		int melhor = 0;
		int verdadeiros = 0, verdadeirosMelhor = sintomas.length;
		int falsos = 0, falsosMelhor = 0;
		for (int j = 0; j < sintomas[0].length;j++) {
			for (int i = 0; i < sintomas.length;i++) {
				if (sintomas[i][j].equals("t"))
					verdadeiros++;
				else
					falsos++;
			}
			if (Math.abs(verdadeiros - falsos) < Math.abs(verdadeirosMelhor - falsosMelhor)){
				melhor = j;
				verdadeirosMelhor = verdadeiros;
				falsosMelhor = falsos;
			}
		}
		return melhor;
	}
	public int[] melhoresPerguntas(String[][] sintomas) {
		int[] perguntas;
		return perguntas;
	}
}
