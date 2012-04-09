package Punto2;
import java.util.Scanner;


public class Calculadora {
	
	 public static int add(String numbers){
		int suma;
		String aux[];
		if(numbers.isEmpty()){
			suma = 0;
		}else{
			aux = numbers.split(",");
			suma = 0;
			for (String x : aux) {
				suma += Integer.parseInt(x);
			}
		}
		
		return suma;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println(add(sc.nextLine()));	
	}
}
