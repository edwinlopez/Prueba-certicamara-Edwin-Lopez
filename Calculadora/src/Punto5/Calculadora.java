package Punto5;
import java.util.Scanner;



public class Calculadora {
	
	 public static int add(String numbers, String delimitador) throws LineaInvalida, NumeroNegativo{
		int suma, token;
		String aux[];
		if(numbers.isEmpty()){
			suma = 0;
		}else{
			if(validarLinea(numbers, delimitador)){
				suma = 0;				
				aux = numbers.split(delimitador);
				for(String x:aux){
					token = Integer.parseInt(x);
					if(token>=0){
						suma += token;
					}else throw new NumeroNegativo(aux);
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
		try{
			if(linea.startsWith("//"))delimitador = obtenerDelimitador(linea);
			else{
				resultado +=add(linea,delimitador);						
			}		
			while(true){
				linea = sc.nextLine().trim();
				resultado +=add(linea,delimitador);
				if(linea.isEmpty())break;
			}
			System.out.println(resultado);
		}catch(LineaInvalida exc){
			System.out.println(exc.getMessage());			
		}catch(NumeroNegativo exc){
			System.out.println(exc.getMessage());
		}catch(NumberFormatException exc){
			System.out.println("Number format exception "+exc.getMessage());
		}	
	}
}
