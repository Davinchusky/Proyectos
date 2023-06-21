public class Moneda {

    private int valor;

    public Moneda(int valor) {
        this.valor = valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(getValor());
    }
    
}
