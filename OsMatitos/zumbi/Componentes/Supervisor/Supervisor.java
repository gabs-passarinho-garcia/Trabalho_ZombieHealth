package zumbi.Componentes.Supervisor;

import java.util.Vector;
import java.io.*;
import zumbi.Interfaces.ISupervisor.ISupervisor;
import java.text.*;


public class Supervisor implements ISupervisor{
	
	private Vector<Vector<Integer>> matrix= new Vector<Vector<Integer>>();
	private Vector<String> index = new Vector<String>();
	
	public Supervisor() {}
	
	public Vector<Vector<Integer>> getMatrix(){
		return matrix;
	}
	
	public Vector<String> getIndex(){
		return index;
	}
	
	public double getAcuracia() {
		int total = LinearAlgebra.somaTotal(matrix);
		return (double) LinearAlgebra.somaDiagonal(matrix) / total;
	}
	
	public void reset() {
		matrix= new Vector<Vector<Integer>>();
		index = new Vector<String>();
	}
	
	
	public String strRelatorio() {
		double acc=0, rec=0, pre=0, spe=0, f1=0;
		int nClass = index.size();
		int lrec=0, lpre=0, lspe=0;
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
		}
			
		
		rec = (double) rec/(total-lrec);
		pre = (double) pre/(total-lpre);
		spe = (double) spe/(total-lspe);
		f1 = f1 + (double) (2*pre*rec)/(pre+rec);
		
		DecimalFormat round = new DecimalFormat("#.00");
		String relatorio = "Acurácia: " + round.format(acc*100) + "%\n";
		relatorio = relatorio + "Precisão: " + round.format(pre*100) + "%\n";
		relatorio = relatorio + "Sensibilidade: " + round.format(rec*100) + "%\n";
		relatorio = relatorio + "Especificidade: " + round.format(spe*100) + "%\n";
		relatorio = relatorio + "F1 score: " + round.format(f1) + "\n";
		
		return relatorio;
	}
	
	public void gerarRelatorio() {
		System.out.print(strRelatorio());
	}
	

	public void motivar() {
		System.out.println(strMotivar());
	}
	
	public String strMotivar() {
		String frase = FrasesGenerator3000.getFrase();
		return frase;
	}
	
	//Adiciona item na matriz de confus�o
	public void reportar(String diag, String doenca) {
		int n;
		int newIndex[] = getIndex(diag, doenca);
		n = matrix.get(newIndex[0]).get(newIndex[1]);
		matrix.get(newIndex[0]).set(newIndex[1], n+1);
	}
	
	//retorna os indices da matriz correspondentes a doen�a
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
	
	public void serializar(String path) {
		try{
			FileOutputStream arquivoGrav = new FileOutputStream(path + "matrix.dat");
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

			objGravar.writeObject(matrix);
			objGravar.flush();
			objGravar.close();
			arquivoGrav.flush();
			arquivoGrav.close();
			
			arquivoGrav = new FileOutputStream(path + "index.dat");
			objGravar = new ObjectOutputStream(arquivoGrav);

			objGravar.writeObject(index);
			objGravar.flush();
			objGravar.close();
			arquivoGrav.flush();
			arquivoGrav.close();
			System.out.println("Objeto gravado com sucesso!");
		}
	 
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void desserializar(String path) {
		Vector<Vector<Integer>> mat;
		Vector<String> ind;
		
		try
	    {
			FileInputStream arquivoLeitura = new FileInputStream(path + "matrix.dat");
			ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
			mat = (Vector<Vector<Integer>>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
			
			arquivoLeitura = new FileInputStream(path + "index.dat");
			objLeitura = new ObjectInputStream(arquivoLeitura);
			ind = (Vector<String>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	return;
	    }
		
		matrix = mat;
		index = ind;
	}
	
	//Apenas para depuracao
	public void imprimir() {
		for (int i=0; i<matrix.size(); i++) {
			for (int j=0; j<matrix.size(); j++) {
				System.out.print(matrix.get(i).get(j) + ", ");
			}
			System.out.println("");
		}
	}

}