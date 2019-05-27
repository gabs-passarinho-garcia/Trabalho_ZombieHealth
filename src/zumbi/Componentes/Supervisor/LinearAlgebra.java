package zumbi.Componentes.Supervisor;
import java.util.*;

public class LinearAlgebra{
    public static int somaColuna(Vector<Vector<Integer>> matriz, int coluna)
    {
        int total = 0;
        for (int i = 0; i < matriz.size(); i++){
            total += (matriz.get(i)).get(coluna);
        }
        return total;
    }
    public static int somaLinha(Vector<Vector<Integer>> matriz, int linha)
    {
        int total = 0;
        for (int i = 0; i < (matriz.get(0)).size(); i++){
            total += (matriz.get(linha)).get(i);
        }
        return total;
    }
    public static int somaDiagonal(Vector<Vector<Integer>> matriz)
    {
        int total = 0;

        for (int i = 0; i < smaller(matriz.size(),(matriz.get(0)).size()); i++){
            total += (matriz.get(i)).get(i);
        }
        return total;
    }
    
    public static int somaTotal(Vector<Vector<Integer>> matriz)
    {
    	int total = 0;
    	for (int i=0; i<matriz.size(); i++) {
    		total = total + somaLinha(matriz, i);
    	}
    	return total;
    }
    
    private static int smaller(int a, int b)
    {
        if (a < b)
            return a;
        return b;
    }
}
