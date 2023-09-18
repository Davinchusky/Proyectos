package clases;

import com.Constantes;

/**
 * Esta clase es el objeto Atributo
 * Los atributos son las caracteristicas de cada atributo. Por ejemplo: Destreza, valor = 15 y modificador +2
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Atributo {

    private int valor;
    private int modificador;

    public Atributo() {
        this.valor = Constantes.ATRIBUTO_MINIMO_INICIAL;
        actualizarModificador();
    }

    public Atributo(int valor) {
        this.valor = valor;
        actualizarModificador();
    }

    /** Devuelve el valor numerico del atributo. EJ: 15
     * @return int
     */
    public int getValor() {
        return valor;
    }

    /** Permite modificar el valor numero del atributo
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
        actualizarModificador();
    }

    /** Devuelve el modificador del atributo. Esta relacionado directamente con el valor. EJ: valor = 15 -> Modiicador = +2
     * @return int
     */
    public int getModificador() {
        return modificador;
    }

    /** Permite modificar el modificador del atributo. Es privado porque depende directamente del valor del atributo
     * @param modificador
     */
    private void setModificador(int modificador) {
        this.modificador = modificador;
    }
    
    /**
     * Funcion que actualiza internamente el modificador cada vez que se actualiza el valor del atributo
     */
    private void actualizarModificador() {
        setModificador(Constantes.mapaModificadoresPuntuacionAtributo.get(valor));
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return getValor() + " ("+getModificador()+")";
    }
}
