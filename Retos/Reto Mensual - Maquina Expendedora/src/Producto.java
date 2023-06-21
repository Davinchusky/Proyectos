public class Producto {
    
    private String nombre;
    private int coste;

    public Producto(String nombre, int coste) {
        this.nombre = nombre;
        this.coste = coste;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return this.coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }
}
