package Punto9;

public class LineaInvalida extends Exception {
	public LineaInvalida(String linea){
		super("L�nea no v�lida "+linea);
	}
}
