package zumbi.Componentes.Supervisor;

import java.util.Vector;
import zumbi.Interfaces.ISupervisor.ISupervisor;


public class Supervisor implements ISupervisor{
	
	private Vector<Vector<Integer>> matrix= new Vector<Vector<Integer>>();
	private Vector<String> index = new Vector<String>();
	
	
	public void gerarRelatorio() {
		double acc, rec, sen, f1;
		System.out.print("p");
	}
	
	//Implementar direito
	public void motivar() {
		System.out.println("yaaay");
	}
	
	//Adiciona item na matriz de confusão
	public void reportar(String diag, String doenca) {
		int n;
		int newIndex[] = getIndex(diag, doenca);
		n = matrix.get(newIndex[0]).get(newIndex[1]);
		matrix.get(newIndex[0]).set(newIndex[1], n+1);
	}
	
	//retorna os indices da matriz correspondentes a doença
	private int[] getIndex(String a, String b) {
		int returnIndex[] = new int[2];
		boolean exist = false;
		
		for (int i=0; i<index.size(); i++) {
			if (a.equalsIgnoreCase(index.get(i))) {
				returnIndex[0] = i;
				exist = true;
			}
		}
		
		if (!exist){
			index.add(a);
			addDimension();
			returnIndex[0] = index.size() - 1;
		}
		
		exist = false;
		
		for (int i=0; i<index.size(); i++) {
			if (b.equalsIgnoreCase(index.get(i))) {
				returnIndex[1] = i;
				exist = true;
			}
		}
		
		if (!exist){
			index.add(b);
			addDimension();
			returnIndex[1] = index.size() - 1;
		}
		
		return returnIndex;
		
	}
	
	private void addDimension(){
		int n = matrix.size();
		for (int i=0; i<matrix.size(); i++) {
			matrix.get(i).add(0);
		}
		Vector<Integer> novo = new Vector<Integer>();
		for (int i=0; i<(n+1); i++) {
			novo.add(0);
		}
		matrix.add(novo);
		
	}
	
	public void imprimir() {
		for (int i=0; i<matrix.size(); i++) {
			for (int j=0; j<matrix.size(); j++) {
				System.out.print(matrix.get(i).get(j) + ", ");
			}
			System.out.println("");
		}
	}

}