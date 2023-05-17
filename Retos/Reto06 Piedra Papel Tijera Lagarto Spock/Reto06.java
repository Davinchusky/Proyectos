/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de piedra, papel,
 *   tijera, lagarto o spock.
 * - Ejemplo. Entrada: tijera - papel. Resultado: "Player 1".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Reto06 {

	private static final String TIJERA = "tijeras";
	private static final String PAPEL = "papel";
	private static final String PIEDRA = "piedra";
	private static final String LAGARTO = "lagarto";
	private static final String SPOCK = "spock";
				
	private static int puntuacion_1 = 0;
	private static int puntuacion_2 = 0;
		
	public static void main(String args[]) {
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduzca el numero de rondas que se van a jugar a piedra, papel, tijeras, lagarto, spock: ");
		int numero_rondas = Integer.parseInt(leer.nextLine());

		ArrayList<String> posiblesValores = new ArrayList<String>();
		
		posiblesValores.add(TIJERA);
		posiblesValores.add(PAPEL);
		posiblesValores.add(PIEDRA);
		posiblesValores.add(LAGARTO);
		posiblesValores.add(SPOCK);
		
		for (int i = 0; i < numero_rondas; i++) {
			System.out.println("Introduzca los jugador 1");
			String jugada_jugador_1 = leer.nextLine();
			
			System.out.println("Introduzca los jugador 2");
			String jugada_jugador_2 = leer.nextLine();
			
			if (posiblesValores.contains(jugada_jugador_1) && posiblesValores.contains(jugada_jugador_2)) {
				verificarRonda(jugada_jugador_1, jugada_jugador_2);
			} else {
				System.out.println("Se ha introducido un valor no valido");
			}
		}
		
		System.out.println("El partido ha finalizado " + puntuacion_1 + " - " + puntuacion_2);
	}
	
	private static void verificarRonda(String jugada_jugador_1, String jugada_jugador_2) {
		if (jugada_jugador_1.equals(TIJERA) && (jugada_jugador_2.equals(PAPEL) || jugada_jugador_2.equals(LAGARTO))) {
			System.out.println("Gana JUGADOR 1");
			++puntuacion_1;
		} else if (jugada_jugador_1.equals(PAPEL) && (jugada_jugador_2.equals(PIEDRA) || jugada_jugador_2.equals(SPOCK))) {
			System.out.println("Gana JUGADOR 1");
			++puntuacion_1;
		} else if (jugada_jugador_1.equals(PIEDRA) && (jugada_jugador_2.equals(TIJERA) || jugada_jugador_2.equals(LAGARTO))) {
			System.out.println("Gana JUGADOR 1");
			++puntuacion_1;
		} else if (jugada_jugador_1.equals(LAGARTO) && (jugada_jugador_2.equals(SPOCK) || jugada_jugador_2.equals(PAPEL))) {
			System.out.println("Gana JUGADOR 1");
			++puntuacion_1;
		} else if (jugada_jugador_1.equals(SPOCK) && (jugada_jugador_2.equals(TIJERA) || jugada_jugador_2.equals(PIEDRA))) {
			System.out.println("Gana JUGADOR 1");
			++puntuacion_1;
		} else if (jugada_jugador_2.equals(TIJERA) && (jugada_jugador_1.equals(PAPEL) || jugada_jugador_1.equals(LAGARTO))) {
			System.out.println("Gana JUGADOR 2");
			++puntuacion_2;
		} else if (jugada_jugador_2.equals(PAPEL) && (jugada_jugador_1.equals(PIEDRA) || jugada_jugador_1.equals(SPOCK))) {
			System.out.println("Gana JUGADOR 2");
			++puntuacion_2;
		} else if (jugada_jugador_2.equals(PIEDRA) && (jugada_jugador_1.equals(TIJERA) || jugada_jugador_1.equals(LAGARTO))) {
			System.out.println("Gana JUGADOR 2");
			++puntuacion_2;
		} else if (jugada_jugador_2.equals(LAGARTO) && (jugada_jugador_1.equals(SPOCK) || jugada_jugador_1.equals(PAPEL))) {
			System.out.println("Gana JUGADOR 2");
			++puntuacion_2;
		} else if (jugada_jugador_2.equals(SPOCK) && (jugada_jugador_1.equals(TIJERA) || jugada_jugador_1.equals(PIEDRA))) {
			System.out.println("Gana JUGADOR 2");
			++puntuacion_2;
		} else {
			System.out.println("Empate");
		}
		System.out.println("Puntuacion 1: " + puntuacion_1);
		System.out.println("Puntuacion 2: " + puntuacion_2);
	}

}