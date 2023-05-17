import java.util.Scanner;

public class Reto02 {

	private static final String LOVE = "LOVE";
	private static final String _15 = "15";
	private static final String _30 = "30";
	private static final String _40 = "40";
	private static final String DEUCE = "DEUCE";
	private static final String VENTAJA = "VENTAJA";
	private static final String VICTORIA = "VICTORIA";

	public static void main(String args[]) {
		
		Jugador player1 = new Jugador();
		Jugador player2 = new Jugador();
		
		player1.nombre = "P1";
		player1.puntuacion = LOVE;
		
		player2.nombre = "P2";
		player2.puntuacion = LOVE;
		
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduzca los nombres de cada jugador (P1 o P2) en orden según marquen puntos, separados por espacios. Por ejemplo: P1 P2 P1 P1 P2 P1: ");
		String cadena = leer.nextLine();
		
		String[] ganadores = cadena.split(" ");
		boolean finalizarPartido = false;
		for (int i = 0; i < ganadores.length && !finalizarPartido; i++) {
			if (ganadores[i].equals("P1")) {
				finalizarPartido = actualizarPuntajes(player1, player2);
			} else if (ganadores[i].equals("P2")) {
				finalizarPartido = actualizarPuntajes(player2, player1);
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("Jugador 1: " + player1.puntuacion);
			System.out.println("Jugador 2: " + player2.puntuacion);
		}
	}
	
	private static boolean actualizarPuntajes(Jugador ganador, Jugador perdedor) {
		switch (ganador.puntuacion){
			case LOVE:
			ganador.puntuacion = _15;
			break;
			case _15:
			ganador.puntuacion = _30;
			break;
			case _30:
			if (perdedor.puntuacion == _40) {
				ganador.puntuacion = DEUCE;
				perdedor.puntuacion = DEUCE;
			} else {
				ganador.puntuacion = _40;
			}
			break;
			case _40:
			if (perdedor.puntuacion == VENTAJA) {
				ganador.puntuacion = DEUCE;
				perdedor.puntuacion = DEUCE;
			} else {
				ganador.puntuacion = VENTAJA;
			}
			break;
			case DEUCE:
			ganador.puntuacion = VENTAJA;
			perdedor.puntuacion = _40;
			break;
			case VENTAJA:
			ganador.puntuacion = VICTORIA;
			return true;
			default:
		}
		return false;
	}

}

	
	class Jugador {
		String nombre;
		String puntuacion;
	};
	