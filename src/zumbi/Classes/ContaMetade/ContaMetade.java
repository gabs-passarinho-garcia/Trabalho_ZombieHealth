package zumbi.Classes.ContaMetade;

import zumbi.Interfaces.IContador.IContador;
import java.lang.Math;
import zumbi.Classes.ConversorString.ConversorString;
import java.util.*;

public class ContaMetade implements IContador {
	public int melhorPergunta(String[][] sintomas) {
		int melhor = 0;
		int verdadeiros, verdadeirosMelhor = sintomas.length;
		int falsos, falsosMelhor = 0;
		for (int j = 0; j < sintomas[0].length;j++) {
			verdadeiros = 0;
			falsos = 0;
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
		int[] perguntas = new int[sintomas.length];
		int pos = 0;
		ArrayList<ArrayList<String>> matrizGeral = ConversorString.converteMatriz(sintomas);
		return perguntas;
	}
}
