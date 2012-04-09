package Punto8;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calculadora {
	
	 public static int add(String numbers, String delimitador) throws LineaInvalida, NumeroNegativo{
		int suma, token;
		String aux[];
		if(numbers.isEmpty()){
			suma = 0;
		}else{
			if(validarLinea(numbers, delimitador)){				
				suma = 0;				
				aux = numbers.split("["+escaparCaracteres(delimitador)+"]{1}");
				for(String x:aux){
					token = Integer.parseInt(x);
					if(token>=0){
						if(token<=1000)suma += token;						
					}else throw new NumeroNegativo(aux);
				}				
			}else throw new LineaInvalida(numbers);
		}
		
		return suma;
	}
	 
	public static String obtenerDelimitador(String linea){
		String delimitadores = "";
		StringTokenizer st = new StringTokenizer(linea.substring(2),"[]");
		while(st.hasMoreTokens()){
			delimitadores += st.nextToken();
		}
		return delimitadores;
	}
	
	public static String escaparCaracteres(String linea){
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");		
		Matcher matcher = pattern.matcher(linea);
		StringBuffer a = new StringBuffer();
		while(matcher.find()){						
			matcher.appendReplacement(a,"\\\\");
			a.append(linea.charAt(matcher.start()));
		}
		matcher.appendTail(a);

		return a.toString();
	}
	
	
	/**
	 * mŽtodo que valida si la l’nea contiene el formato requerido
	 * @return true si la l’nea es v‡lida, false de lo contrario
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
