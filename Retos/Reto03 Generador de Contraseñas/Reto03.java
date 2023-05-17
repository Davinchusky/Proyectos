/*
 * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros:
 * - Longitud: Entre 8 y 16.
 * - Con o sin letras mayúsculas.
 * - Con o sin números.
 * - Con o sin símbolos.
 * (Pudiendo combinar todos estos parámetros entre ellos)
 */
 import java.util.Scanner;
 import java.util.Random;
 
 public class Reto03 {

	private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	private static final String MAYUSCULAS = "ABCDEFGHIJKMLNOPQRSTUVWXYZ";
	private static final String NUMEROS = "1234567890";
	private static final String SIMBOLOS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
	
	private static final String CON = "con";
	private static final String SIN = "sin";
	
	
	public static void main(String args[]) {
		Scanner leer = new Scanner(System.in);
		
		String caracteres = MINUSCULAS;
		
		System.out.println("Longitud de la contrasena (entre 8 y 16)");
		String cadena = leer.nextLine();
		
		int longitud = Integer.parseInt(cadena);
		if (longitud < 8) {
			longitud = 8;
		} else if (longitud > 16) {
			longitud = 16;
		}
		
		System.out.println("¿Con o sin letras mayusculas?");
		cadena = leer.nextLine();
		
		if (cadena.equalsIgnoreCase(CON)) {
			caracteres += MAYUSCULAS;
		}
		
		System.out.println("¿Con o sin letras numeros?");
		cadena = leer.nextLine();
		
		if (cadena.equalsIgnoreCase(CON)) {
			caracteres += NUMEROS;
		}
		
		System.out.println("¿Con o sin letras simbolos?");
		cadena = leer.nextLine();
		
		if (cadena.equalsIgnoreCase(CON)) {
			caracteres += SIMBOLOS;
		}
		
		String contrasenia = "";
		while (contrasenia.length() < longitud) {
			int numeroRandom = (int) (Math.random()*caracteres.length());
			char caracter = caracteres.charAt(numeroRandom);
			contrasenia += String.valueOf(caracter);
		}
		
		System.out.println("Contrasenia: " + contrasenia);
	}

}