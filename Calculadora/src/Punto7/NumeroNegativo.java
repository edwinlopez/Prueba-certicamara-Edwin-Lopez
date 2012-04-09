package Punto7;
import java.util.ArrayList;

public class NumeroNegativo extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NumeroNegativo(String[] a){
		super("negatives not allowed ");
		int valor;
		ArrayList<Integer> negativos = new ArrayList<Integer>();
		for(String x:a){
			valor = Integer.parseInt(x);
			if(valor<0)negativos.add(valor);
		}
		System.out.println(negativos);
	}
}
