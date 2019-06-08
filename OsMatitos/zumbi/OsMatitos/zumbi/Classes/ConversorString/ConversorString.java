package zumbi.Classes.ConversorString;

import java.util.Arrays;
import java.util.ArrayList;

public class ConversorString {
	public static ArrayList<String> converteVetor(String[] vetor) {
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(vetor));
		return lista;
	}

	public static ArrayList<ArrayList<String>> converteMatriz(String[][] matriz) {
		ArrayList<ArrayList<String>> matrizLegal = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < matriz.length; i++) {
			matrizLegal.add(converteVetor(matriz[i]));
		}
		return matrizLegal;
	}
}
