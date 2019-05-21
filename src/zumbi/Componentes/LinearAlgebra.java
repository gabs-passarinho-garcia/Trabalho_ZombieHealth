import java.util.*;

public class LinearAlgebra{
    public static int somaColuna(Vector<Vector<int>> matriz, int coluna)
    {
        int total = 0;
        for (int i = 0; i < matriz.size(); i++){
            total += matriz[i][coluna];
        }
        return total;
    }
    public static int somaLinha(Vector<Vector<int>> matriz, int linha)
    {
        int total = 0;
        for (int i = 0; i < matriz[0].size(); i++){
            total += matriz[linha][i];
        }
        return total;
    }
    public static int somaDiagonal(Vector<Vector<int>> matriz)
    {
        int total = 0;

        for (int i = 0; i < smaller(matriz.size(),matriz[0].size()); i++){
            total += matriz[i][i];
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
