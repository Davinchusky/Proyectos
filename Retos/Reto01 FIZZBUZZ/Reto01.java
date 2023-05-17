/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */
 public class Reto01 {

	public static void main(String args[]) {
		for (int i = 1; i <= 100; i++) {
			int resultado_3 = i % 3;
			int resultado_5 = i % 5;
			String texto = "";
			
			if (resultado_3 == 0 && resultado_5 == 0) {
				texto = "FIZZBUZZ";
			} else if (resultado_3 == 0) {
				texto = "FIZZ";
			} else if (resultado_5 == 0) {
				texto = "BUZZ";
			} else {
				texto = String.valueOf(i);
			}
			
			System.out.println(texto);
		}
	}
}