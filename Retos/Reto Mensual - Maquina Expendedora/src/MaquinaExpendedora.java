import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaExpendedora implements Runnable {
    
    private String nombre;
    private List<Producto> listaProductos;
    private int saldo;
    private Estados estado;
    private List<Moneda> monedasAceptadas;
    private Scanner sc;

    public MaquinaExpendedora(String nombre, List<Producto> listaProductos, Scanner sc) {
        this.nombre = nombre;
        this.listaProductos = listaProductos;
        this.saldo = 0;
        this.estado = Estados.DEFAULT;
        this.monedasAceptadas = new ArrayList<>();
        aniadirMonedas();
        this.sc = sc;
    }

    private void aniadirMonedas() {
        monedasAceptadas.add(Constantes.CENTS_200_MONEDA);
        monedasAceptadas.add(Constantes.CENTS_100_MONEDA);
        monedasAceptadas.add(Constantes.CENTS_50_MONEDA);
        monedasAceptadas.add(Constantes.CENTS_20_MONEDA);
        monedasAceptadas.add(Constantes.CENTS_10_MONEDA);
    }

    public synchronized Estados getEstado() {
        return estado;
    }

    public synchronized void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getListaProductos() {
        return this.listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void aniadirSaldo(int saldo) {
        this.saldo += saldo;
    }

    public List<Moneda> getMonedasAceptadas() {
        return monedasAceptadas;
    }

    public void setMonedasAceptadas(List<Moneda> monedasAceptadas) {
        this.monedasAceptadas = monedasAceptadas;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                this.wait(100);
                switch(estado) {
                    case IMPRIMIR_MENU:
                        System.out.println("/----------------------"+ getNombre() + "--------------------------/");
                        printProductos();
                        System.out.println("/----------------------------------------------------------/");
                        break;
                    case CONSULTAR_SALDO:
                        System.out.println("/----------------------"+ getNombre() + "--------------------------/");
                        System.out.println("Saldo disponible en " + getNombre() + " es " + getSaldo() + " cents"); 
                        System.out.println("/----------------------------------------------------------/");
                        break;
                    case INSERTAR_SALDO:
                        System.out.println("/----------------------"+ getNombre() + "--------------------------/");
                        synchronized (sc) {
                            meterSaldo();
                            System.out.println("/----------------------------------------------------------/");
                            sc.notify();
                        }
                        break;
                    case RETIRAR_SALDO:
                        System.out.println("/----------------------"+ getNombre() + "--------------------------/");
                        synchronized (sc) {
                            retirarSaldo();
                            System.out.println("/----------------------------------------------------------/");
                            sc.notify();
                        }
                        break;
                    case OBTENER_PRODUCTO:
                        System.out.println("/----------------------"+ getNombre() + "--------------------------/");
                        synchronized (sc) {
                            obtenerProducto();
                            System.out.println("/----------------------------------------------------------/");
                            sc.notify();
                        }
                        break;
                    case FINALIZAR:
                        throw new Exception("Fin ejecución");
                    case DEFAULT:
                    default:
                        break;
                }
                setEstado(Estados.DEFAULT);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Se ha finalizado " + getNombre());
        }
    }

    private void obtenerProducto() {
        System.out.println("Elija qué producto desea obtener");
        System.out.print("Nombre:");
        for (Producto producto : listaProductos) {
            System.out.print(" ["+producto.getNombre()+"]");
        }

        System.out.println("\nIntroduzca el nombre del producto que desea:");
        String nombre_producto = sc.nextLine();
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre_producto)) {
                if (getSaldo() >= producto.getCoste()) {
                    System.out.println("Se ha elegido " + producto.getNombre());
                    System.out.println("Soltando prodcuto...");
                    setSaldo(saldo - producto.getCoste());
                    System.out.println("Nuevo saldo: " + getSaldo());
                } else {
                    System.err.println("Saldo insuficiente... Saldo actual: " + getSaldo() + " cents. Coste: " + producto.getCoste() + " cents");
                    break;
                }
            }
        }
    }

    private void retirarSaldo() {
        if (getSaldo() > 0) {
            while (getSaldo() != 0) {
                for (Moneda moneda : monedasAceptadas) {
                    int num_monedas = saldo / moneda.getValor();
                    if (num_monedas > 0) {
                        setSaldo(saldo % moneda.getValor());
                        System.out.println("Se devuelven " + num_monedas + " de " + moneda.getValor() + " cents. Saldo restante: " + saldo);
                    }
                }
            }
        } else {
            System.out.println("No hay saldo en esta máquina");
        }
    }

    private void printProductos()  {
        System.out.println("******************* " + this.nombre + " *******************");
        for(Producto producto : this.listaProductos) {
            System.out.println("*       " + producto.getNombre() + ": " + producto.getCoste() + " cents     *");
        }
        System.out.println("*************************************************\n");
    }

    private void meterSaldo() {
        System.out.println("Introduzca las monedas que desea insertar en " + getNombre());
        System.out.println("Se introducen de 1 en una. Monedas aceptadas: " + monedasAceptadas.toString());
        while (true) {
            System.out.print("Inserte una moneda o -1 para salir: ");
            String cadena = sc.nextLine();
            if (cadena.equals("-1")) {
                System.out.println("Se deja de meter saldo a la máquina.");
                break;
            }
            
            for (Moneda moneda : getMonedasAceptadas()) {
                try {
                    if (moneda.getValor() == Integer.valueOf(cadena)) {
                        System.out.println("Se ha insertado una moneda de: " + moneda.getValor() + " cents");
                        aniadirSaldo(moneda.getValor());
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ha introducido un valor que no se corresponde con una moneda que acepte la máquina.");
                }
            }

        }
    }
}
