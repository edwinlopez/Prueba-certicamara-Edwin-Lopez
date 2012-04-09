package Punto3;
import java.util.Scanner;
import java.util.StringTokenizer;

import Punto4.LineaInvalida;


public class Calculadora {
	
	 public static int add(String numbers) throws LineaInvalida{
		int suma;
		if(numbers.isEmpty()){
			suma = 0;
		}else{
			if(validarLinea(numbers)){
				suma = 0;
				StringTokenizer st = new StringTokenizer(numbers);
				while(st.hasMoreTokens()){
					suma += Integer.parseInt(st.nextToken());
				}
			}else throw new LineaInvalida(numbers);
		}
		
		return suma;
	}
	 
	/**
	 * método que valida si la línea contiene el formato requerido
	 * @return true si la línea es válida, false de lo contrario
	 */
	public static boolean validarLinea(String linea){
		return (!linea.startsWith(",")&&!linea.endsWith(",")&&!linea.contains(","+","));
	}	 
	
	public static void main(String[] args){
		int resultado = 0;
		String aux;
		Scanner sc = new Scanner(System.in);
		while(true){
			aux = sc.nextLine().trim();			
			try{
				resultado += add(aux);
			}catch(LineaInvalida exc){
				System.out.println(exc.getMessage());
				System.exit(0);
			}
			
			if(aux.isEmpty())break;
		}
		
		System.out.println(resultado);	
	}
}
