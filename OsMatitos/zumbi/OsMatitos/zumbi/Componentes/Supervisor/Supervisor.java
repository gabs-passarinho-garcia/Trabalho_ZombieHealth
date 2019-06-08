package zumbi.Componentes.Supervisor;

import java.util.Vector;
import zumbi.Interfaces.ISupervisor.ISupervisor;


public class Supervisor implements ISupervisor{
	
	private Vector<Vector<Integer>> matrix= new Vector<Vector<Integer>>();
	private Vector<String> index = new Vector<String>();
	
	
	public void gerarRelatorio() {
		double acc=0, rec=0, pre=0, spe=0, f1=0;
		int nClass = index.size();
		int lAcc=0, lrec=0, lpre=0, lspe=0, lf1=0;
		int total = LinearAlgebra.somaTotal(matrix);
		acc = (double) LinearAlgebra.somaDiagonal(matrix) / total;
		
		for (int i=0; i<nClass; i++) {
			double tp, fp, fn, tn;
			tp = matrix.get(i).get(i);
			fp = LinearAlgebra.somaLinha(matrix, i) - tp;
			fn = LinearAlgebra.somaColuna(matrix, i) - tp;
			tn = LinearAlgebra.somaDiagonal(matrix) - tp;
		
			if(tp+fn != 0) {
				rec = rec + (double) tp/(tp+fn);
			}
			else {
				lrec = lrec + 1;
			}
			if (tp+fp != 0) {
				pre = pre + (double) tp/(tp+fp);
			}
			else {
				lpre = lpre + 1;
			}
			if(tn+fp != 0) {
				spe = spe + (double) tn/(tn+fp);
			}
			else {
				lspe = lspe + 1;
			}
			if(pre+rec != 0) {
			f1 = f1 + (double) (2*pre*rec)/(pre+rec);
			}
			else {
				lf1 = lf1 + 1;
			}
		}
			
		
		rec = (double) rec/(total-lrec);
		pre = (double) pre/(total-lpre);
		spe = (double) spe/(total-lspe);
		f1 = (double) f1/(total-lf1);
		
		System.out.println(acc + ", " + pre + ", " + spe + ", " + f1);
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