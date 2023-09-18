package clases;

import java.util.HashMap;
import java.util.Map;

import com.Constantes;

/**
 * Esta clase es el objeto Personaje
 * Los atributos son el conjunto de objetos que contienen la informacion del personaje, 
 * como pueden ser razas, clases o habilidades
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Personaje {

    private Caracteristicas caracteristicas;
    private Raza raza;
    private Clase clase;
    private Map<String, Atributo> atributos;
    Map<String, Habilidades> habilidades;

    public Personaje() {
        caracteristicas = new Caracteristicas();
        raza = new Raza();
        clase = new Clase();
        atributos = new HashMap<>();
        habilidades = new HashMap<>();
    }

    public Personaje(Caracteristicas caracteristicas, Raza raza, Clase clase, Map<String, Atributo> atributos, Map<String, Habilidades> habilidades) {
        this.caracteristicas = caracteristicas;
        this.raza = raza;
        this.clase = clase;
        this.atributos = atributos;
        this.habilidades = habilidades;
    }

    /** 
     * @return Caracteristicas
     */
    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }
    
    /** 
     * @param caracteristicas
     */
    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    /** 
     * @return Raza
     */
    public Raza getRaza() {
        return raza;
    }
    
    /** 
     * @param raza
     */
    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    
    /** 
     * @return Clase
     */
    public Clase getClase() {
        return clase;
    }
    
    /** 
     * @param clase
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
    /** 
     * @return List<Atributo>
     */
    public Map<String, Atributo> getAtributos() {
        return atributos;
    }
    
    /** 
     * @param atributos
     */
    public void setAtributos(Map<String, Atributo> atributos) {
        this.atributos = atributos;
    }
    
    /** 
     * @return Map<String, Habilidades>
     */
    public Map<String, Habilidades> getHabilidades() {
        return habilidades;
    }

    /** 
     * @param habilidades
     */
    public void setHabilidades(Map<String, Habilidades> habilidades) {
        this.habilidades = habilidades;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Personaje: \n" +
                "Características: " + getCaracteristicas().toString() + "\n" +
                "Raza: " + getRaza() + "\n" + 
                "Clase: " + getClase() + "\n" +
                "Atributos: " + getAtributos().toString() + "\n" +
                "Habilidades: " + getHabilidades().toString();
    }

    public String getCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constantes.getCabecera());
        sb.append(Constantes.SALTO_DE_LINEA);
        sb.append(getRaza().getNombre());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getClase().getNombre());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getCaracteristicas().getCSV());
        sb.append(Constantes.SEPARADOR_CSV);
        for (String nombre : getAtributos().keySet()) {
            Atributo atributo = getAtributos().get(nombre);
            sb.append(atributo.getValor());
            sb.append(Constantes.SEPARADOR_CSV);
        }
        for (String nombre : getHabilidades().keySet()) {
            Habilidades habilidad = getHabilidades().get(nombre);
            sb.append(habilidad.getModificadorCompetencia());
            sb.append(Constantes.SEPARADOR_CSV);
            sb.append(habilidad.getModificadorHabilidad());
            sb.append(Constantes.SEPARADOR_CSV);
        }

        return sb.toString();
    }
}
