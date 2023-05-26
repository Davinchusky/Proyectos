import java.util.Scanner;

public class App {

    void run() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduzca el número de escalones (signo negativo sera descente y positivo ascendente): ");
        int totalEscalones = scan.nextInt();
        scan.close();
        
        dibujarEscalones(totalEscalones);
    }

    private static void dibujarEscalones(int totalEscalones) {
        String cadena = generarCadena(totalEscalones);

        System.out.println(cadena);
    }

    private static String generarCadena(int totalEscalones) {
        String cadena = (totalEscalones > 0) ? "" : Constantes.ESPACIO + Constantes.GUION_INICIO;

        int valorAbsoluto = Math.abs(totalEscalones);


        if (totalEscalones < 0) {
            for (int i = 0; i < valorAbsoluto; i++) {
                cadena = aniadirTabulaciones(cadena, i);
                cadena += Constantes.ESCALON_DESCENTE;
            }
        } else if (totalEscalones > 0) {
            for (int i = valorAbsoluto; i > 0; i--) {
                if (i == valorAbsoluto) {
                    cadena = aniadirTabulaciones(cadena, i-1);
                    cadena += Constantes.GUION_INICIO;
                }
                cadena = aniadirTabulaciones(cadena, i-2);
                cadena += Constantes.ESCALON_ASCENDENTE;
            }
        }
        return cadena;
    }

    private static String aniadirTabulaciones(String cadena, int i) {
        for (int j = 0; j <= i; j++) { // Aniadir las tabulaciones
            cadena += Constantes.ESPACIO;
            cadena += Constantes.ESPACIO;
        }
        return cadena;
    }
}
