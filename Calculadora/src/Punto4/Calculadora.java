package Punto4;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Calculadora {
	
	 public static int add(String numbers, String delimitador) throws LineaInvalida{
		int suma;		
		if(numbers.isEmpty()){
			suma = 0;
		}else{
			if(validarLinea(numbers, delimitador)){
				suma = 0;
				StringTokenizer st = new StringTokenizer(numbers,delimitador);
				while(st.hasMoreTokens()){
					suma += Integer.parseInt(st.nextToken());
				}
			}else throw new LineaInvalida(numbers);								
			
		}
		
		return suma;
	}
	 
	public static String obtenerDelimitador(String linea){
		
		return linea.substring(2);
	}
	
	/**
	 * método que valida si la línea contiene el formato requerido
	 * @return true si la línea es válida, false de lo contrario
	 */
	public static boolean validarLinea(String linea, String delimitador){
		return (!linea.startsWith(delimitador)&&!linea.endsWith(delimitador)&&!linea.contains(delimitador+delimitador));
	}
	
	
	public static void main(String[] args){
		int resultado = 0;
		String linea,delimitador = ",";
		Scanner sc = new Scanner(System.in);
		linea = sc.nextLine().trim();
		if(linea.startsWith("//"))delimitador = obtenerDelimitador(linea);
		else{
			try{
				resultado +=add(linea,delimitador);
			}catch(LineaInvalida exc){
				System.out.println("Línea no válida");
				System.exit(0);
			}			
		} 
		
		while(true){
			linea = sc.nextLine().trim();
			try{
				resultado +=add(linea,delimitador);
			}catch(LineaInvalida exc){
				System.out.println(exc.getMessage());
				System.exit(0);
			}
			if(linea.isEmpty())break;
		}
		
		System.out.println(resultado);	
	}
}
