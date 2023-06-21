import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Producto agua = new Producto("Agua", 40);
    Producto coca_cola = new Producto("Coca Cola", 70);
    Producto fanta_naranja = new Producto("Fanta naranja", 70);
    Producto fanta_limon = new Producto("Fanta limon", 70);
    Producto cafe = new Producto("Cafe", 80);

    Producto kit_kat = new Producto("Kit Kat", 90);
    Producto huesitos = new Producto("Huesitos", 90);
    Producto croissant = new Producto("Croissant", 110);
    Producto sandwich = new Producto("Sandwich", 140);
    Producto bocadillo = new Producto("Bocadillo", 170);


    public synchronized void ejecucion_proceso() throws InterruptedException {
        
        // Definicion de los objetos de las maquinas
        List<Producto> bebidas = new ArrayList<>();
        bebidas.add(agua);
        bebidas.add(coca_cola);
        bebidas.add(fanta_naranja);
        bebidas.add(fanta_limon);
        bebidas.add(cafe);

        List<Producto> comidas = new ArrayList<>();
        comidas.add(kit_kat);
        comidas.add(huesitos);
        comidas.add(croissant);
        comidas.add(sandwich);
        comidas.add(bocadillo);

        Scanner sc = new Scanner(System.in);

        // Creacion de maquinas expendedoras
        List<MaquinaExpendedora> listaMaquinas = new ArrayList<>();
        MaquinaExpendedora maquina1 = new MaquinaExpendedora("Maquina 1", bebidas, sc);
        MaquinaExpendedora maquina2 = new MaquinaExpendedora("Maquina 2", comidas, sc);
        listaMaquinas.add(maquina1);
        listaMaquinas.add(maquina2);

        // Lanzamos las maquinas expendedores
        Thread hilo_1 = new Thread(maquina1);
        Thread hilo_2 = new Thread(maquina2);

        hilo_1.setName("Maquina 1");
        hilo_2.setName("Maquina 2");

        hilo_1.start();
        hilo_2.start();
        
        System.out.println("Introduzca el producto que desea: ");
        imprimirMenu();
        while (true) {
            String cadena = sc.nextLine();
            if (cadena.equalsIgnoreCase(Constantes.EXIT)) {
                break;
            }
            if (cadena.equals("0")) {
                imprimirMenu();
            } else if (cadena.equals("1")) {
                maquina1.setEstado(Estados.IMPRIMIR_MENU);
                Thread.sleep(500);
                maquina2.setEstado(Estados.IMPRIMIR_MENU);
            } else if (cadena.equals("2")) {
                maquina1.setEstado(Estados.CONSULTAR_SALDO);
                Thread.sleep(500);
                maquina2.setEstado(Estados.CONSULTAR_SALDO);
            } else {
                Estados nuevo_estado = Estados.DEFAULT;
                if (cadena.equals("3")) {
                    nuevo_estado = Estados.INSERTAR_SALDO;
                } else if (cadena.equals("4")) {
                    nuevo_estado = Estados.RETIRAR_SALDO;
                } else if (cadena.equals("5")) {
                    nuevo_estado = Estados.OBTENER_PRODUCTO;
                } else {
                    break;
                }
                MaquinaExpendedora maquina = preguntarMaquina(sc, listaMaquinas);
                setearEstadoParaMaquina(maquina, nuevo_estado);
                synchronized (sc) {
                    sc.wait();
                    imprimirMenu();
                }
            }
            
        }

        // Se notifica a los hilos para finalizar
        maquina1.setEstado(Estados.FINALIZAR);
        maquina2.setEstado(Estados.FINALIZAR);
        
        // Se cierra el Scanner
        sc.close();
    }

    private void imprimirMenu() {
        System.out.println("***********************************************************");
        System.out.println("*  Si desea volver a ver este menú pulse 0                *");
        System.out.println("*  Si desea ver los productos de las máquinas pulse 1     *");
        System.out.println("*  Si desea consultar el saldo de las máquinas pulse 2    *");
        System.out.println("*  Si desea insertar saldo en alguna máquina pulse 3      *");
        System.out.println("*  Si desea retirar el saldo de alguna máquina pulse 4    *");
        System.out.println("*  Si desea retirar un producto de alguna máquina pulse 5 *");
        System.out.println("*  Si desea finalizar, escriba exit                       *");
        System.out.println("***********************************************************");
    }

    public MaquinaExpendedora preguntarMaquina(Scanner sc, List<MaquinaExpendedora> listaMaquinas) {
        System.out.println("¿Sobre qué máquina quiere interactuar? Debe escribir el nombre de la máquina");
        System.out.print("Nombres:");
        for (MaquinaExpendedora maquina : listaMaquinas) {
            System.out.print(" [" + maquina.getNombre() + "]");
        }
        System.out.print("\n");
        String cadena = "";
        while (true) {
            cadena = sc.nextLine();
            for (MaquinaExpendedora maquina : listaMaquinas) {
                if (maquina.getNombre().equalsIgnoreCase(cadena)) {
                    return maquina;
                }
            }
            System.out.println("Introduzca un nombre válido.");
        }
    }

    private void setearEstadoParaMaquina(MaquinaExpendedora maquina, Estados estado) {
        maquina.setEstado(estado);
    }
}
